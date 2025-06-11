package Model.Lagu;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableLagu extends AbstractTableModel{
    List<ModelLagu> lgu;
    String kolom[] = {"Id","Judul Lagu", "Penyanyi", "Album", "Genre", "Gambar", "Link Lagu"};


    public ModelTableLagu(List<ModelLagu> lgu) {
        this.lgu = lgu;
    }

    @Override
    public int getRowCount() {
        return lgu.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 5) {
            // Kita cek apa isi URL sebelum dikembalikan
            String url = lgu.get(rowIndex).getGambar();
            System.out.println(
                    "DEBUG: getValueAt [Baris: " + rowIndex + ", Kolom: 5] -> URL: '" + url + "'"
            );
        }
        switch (columnIndex) {
            case 0:
                return lgu.get(rowIndex).getIdLagu();
            case 1:
                return lgu.get(rowIndex).getJudulLagu();
            case 2:
                return lgu.get(rowIndex).getPenyanyi();
            case 3:
                return lgu.get(rowIndex).getAlbum();
            case 4:
                return lgu.get(rowIndex).getGenre();
            case 5:
                return lgu.get(rowIndex).getGambar();
            case 6:
                return lgu.get(rowIndex).getLinkLagu();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

}
