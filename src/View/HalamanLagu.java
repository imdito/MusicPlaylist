package View;

import Controller.ControllerHalamanLagu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Akun.ModelAkun;
public class HalamanLagu extends JFrame {
    Integer barisTerpilih;
    private JPanel MainPanel;
    private JTable tableLagu;
    private JTextField judulLaguField;
    private JTextField linkField;
    private JTextField penyanyiField;
    private JTextField gambarField;
    private JTextField albumField;
    private JTextField genreField;
    private JButton updateLaguButton;
    private JButton inputLaguButton;
    private JButton hapusLaguButton;
    private JButton clearButton;
    private JButton backButton;
    ControllerHalamanLagu controllerHalamanLagu;
    String kolomLagu[] = {"ID","Judul Lagu", "Penyanyi", "Album", "Genre", "Gambar", "Link Lagu"};


    public HalamanLagu(ModelAkun akun) {
        setTitle("Halaman Lagu");
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        controllerHalamanLagu = new ControllerHalamanLagu(this);
        controllerHalamanLagu.tampilkanDaftarLagu();
        // Initialize components and add action listeners if needed
        updateLaguButton.addActionListener(e -> {

            // Logic for updating a song
            if (barisTerpilih != null) {
                int idLagu = (int) tableLagu.getValueAt(barisTerpilih, 0); // Assuming the first column is the ID
                controllerHalamanLagu.updateLagu(idLagu);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih lagu yang ingin diupdate!");
            }

        });

        inputLaguButton.addActionListener(e -> {
            // Logic for inputting a new song
            controllerHalamanLagu.inputLagu();
        });

        hapusLaguButton.addActionListener(e -> {
            // Logic for deleting a song
            if (barisTerpilih != null) {
                System.out.println("Baris terpilih: " + barisTerpilih);
                controllerHalamanLagu.deleteLagu(barisTerpilih);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih lagu yang ingin dihapus!");
            }
        });

        clearButton.addActionListener(e -> {
            // Logic for clearing fields
            judulLaguField.setText("");
            linkField.setText("");
            penyanyiField.setText("");
            gambarField.setText("");
            albumField.setText("");
            genreField.setText("");
        });
        tableLagu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                barisTerpilih = tableLagu.getSelectedRow();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanUtama(akun);
                dispose();
            }
        });
    }

    public JTextField getJudulLaguField() {
        return judulLaguField;
    }
    public JTextField getLinkField() {
        return linkField;
    }
    public JTextField getPenyanyiField() {
        return penyanyiField;
    }
    public JTextField getGambarField() {
        return gambarField;
    }
    public JTextField getAlbumField() {
        return albumField;
    }
    public JTextField getGenreField() {
        return genreField;
    }


    public JTable getAllLagu() {
        return tableLagu;
    }
}
