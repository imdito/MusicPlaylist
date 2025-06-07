package Model.PlayList;
import Model.ConnectDatabase;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTablePlaylist extends AbstractTableModel {

    List<ModelPlaylist> playlist;
    String kolom[] = {"ID", "Nama Playlist"};

    public ModelTablePlaylist(List<ModelPlaylist> playlist) {
        this.playlist = playlist;
    }

    @Override
    public int getRowCount() {
        return playlist.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return playlist.get(rowIndex).getIdPlaylist();
            case 1:
                return playlist.get(rowIndex).getNamePlaylist();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

}
