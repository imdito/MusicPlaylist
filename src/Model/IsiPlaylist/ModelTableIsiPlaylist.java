package Model.IsiPlaylist;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTableIsiPlaylist extends AbstractTableModel {
    private String[] kolom = {"ID", "Judul Lagu", "Penyanyi", "Genre"};
    private List<ModelIsiPlaylist> isiPlaylist;

    public ModelTableIsiPlaylist(List<ModelIsiPlaylist> isiPlaylist) {
        this.isiPlaylist = isiPlaylist;
    }

    @Override
    public int getRowCount() {
        return isiPlaylist.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
              return isiPlaylist.get(rowIndex).getIdIsiPlaylist();
            case 1:
                return isiPlaylist.get(rowIndex).getJudulLagu();
            case 2:
                return isiPlaylist.get(rowIndex).getPenyanyi();
            case 3:
                return isiPlaylist.get(rowIndex).getGenre();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }
}
