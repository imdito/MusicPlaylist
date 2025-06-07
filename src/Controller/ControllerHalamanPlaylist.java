package Controller;

import Model.IsiPlaylist.InterfaceDAOIsiPlaylistLagu;
import Model.Lagu.ModelLagu;
import Model.PlayList.DAOPlaylist;
import Model.PlayList.InterfacePlaylistLagu;
import Model.PlayList.ModelPlaylist;
import Model.PlayList.ModelTablePlaylist;
import View.HalamanPlaylist;

import javax.swing.*;
import java.util.List;

public class ControllerHalamanPlaylist {


    List<ModelPlaylist> daftarPlaylists;
    InterfacePlaylistLagu  daoPlaylist;
    HalamanPlaylist halamanPlaylist;

    public ControllerHalamanPlaylist(HalamanPlaylist halamanPlaylist) {
        this.halamanPlaylist = halamanPlaylist;
        this.daoPlaylist = new DAOPlaylist();

    }

    public void tampilkanDaftarPlaylist() {
        daftarPlaylists = daoPlaylist.getAllPlaylists();
        ModelTablePlaylist modelTablePlaylist = new ModelTablePlaylist(daftarPlaylists);
        halamanPlaylist.getTablePlaylist().setModel(modelTablePlaylist);
    }

    public void tambahPlaylist() {
        try {

            ModelPlaylist plst = new ModelPlaylist();
            plst.setNamePlaylist(halamanPlaylist.getNamafield());

            if ("".equals(halamanPlaylist.getNamafield())) {
                throw new Exception("Nama Playlist tidak boleh kosong!");

            }

            daoPlaylist.createPlaylist(plst);
            tampilkanDaftarPlaylist();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updatePlaylist(int id) {
        try {
            int selectedRow = halamanPlaylist.getTablePlaylist().getSelectedRow();
            if (selectedRow == -1) {
                throw new Exception("Pilih lagu yang ingin diupdate!");
            }

            ModelPlaylist playlist = daftarPlaylists.get(selectedRow);
            playlist.setIdPlaylist(id);
            playlist.setNamePlaylist(halamanPlaylist.getNamafield());
            daoPlaylist.updatePlaylist(playlist);
            tampilkanDaftarPlaylist();
            JOptionPane.showMessageDialog(null, "Data lagu berhasil diupdate.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePlaylist(int id) {
        try {
            int aidi = (int) halamanPlaylist.getTablePlaylist().getValueAt(id, 0);
            String namaplaylist = halamanPlaylist.getTablePlaylist().getValueAt(id, 1).toString();
            int input = JOptionPane.showConfirmDialog(
                    null,
                    "Hapus " + namaplaylist + " ?",
                    "Hapus Lagu",
                    JOptionPane.YES_NO_OPTION
            );

            if (input == 0) {
                daoPlaylist.deletePlaylist(aidi);
                tampilkanDaftarPlaylist();
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tampilkanPlaylist(){

        daftarPlaylists = daoPlaylist.getAllPlaylists();
        ModelTablePlaylist modelTablePlaylist = new ModelTablePlaylist(daftarPlaylists);
        halamanPlaylist.getTablePlaylist().setModel(modelTablePlaylist);


    }

}
