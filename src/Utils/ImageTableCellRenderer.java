package Utils;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageTableCellRenderer extends DefaultTableCellRenderer {

    // Cache untuk menyimpan gambar yang sudah diunduh. Kunci: URL (String), Nilai: ImageIcon
    private final Map<String, ImageIcon> imageCache = new HashMap<>();
    private final JLabel label = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Setup dasar label (warna background, dll)
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String imageUrl = (String) value;
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText(null); // Selalu mulai dengan teks kosong

        if (imageUrl != null && !imageUrl.isEmpty()) {
            // LANGKAH 1: Cek apakah gambar sudah ada di cache
            if (imageCache.containsKey(imageUrl)) {
                // Jika ada, langsung gunakan dari cache, tidak perlu unduh lagi
                label.setIcon(imageCache.get(imageUrl));
                // System.out.println("Gambar diambil dari cache untuk: " + imageUrl);
            } else {
                // LANGKAH 2: Jika tidak ada di cache, tampilkan placeholder dan mulai unduh
                label.setIcon(null); // Tampilkan ikon kosong sementara
                label.setText("..."); // Teks loading

                // Buat SwingWorker untuk mengunduh
                SwingWorker<ImageIcon, Void> worker = new SwingWorker<>() {
                    @Override
                    protected ImageIcon doInBackground() throws Exception {
                        // Kita tetap menggunakan ImageLoader untuk logika unduh dan scale
                        return ImageLoader.loadImageAndScale(imageUrl, 60, 60);
                    }

                    @Override
                    protected void done() {
                        try {
                            ImageIcon loadedIcon = get();
                            if (loadedIcon != null) {
                                // Jika berhasil, simpan ke cache untuk penggunaan selanjutnya
                                imageCache.put(imageUrl, loadedIcon);
                                // Set ikon ke label
                                label.setIcon(loadedIcon);
                                label.setText(null);
                            } else {
                                label.setText("Gagal");
                            }
                        } catch (Exception e) {
                            label.setText("Error");
                        }
                        // Repaint sel untuk menampilkan gambar yang baru dimuat atau status error
                        table.repaint(table.getCellRect(row, column, false));
                    }
                };
                worker.execute();
            }
        } else {
            label.setIcon(null);
            label.setText("No Image");
        }

        return label;
    }
}