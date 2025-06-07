package Controller;

import Model.IsiPlaylist.DAOIsiPlaylist;
import Model.IsiPlaylist.InterfaceDAOIsiPlaylistLagu;
import Model.IsiPlaylist.ModelIsiPlaylist;
import Model.IsiPlaylist.ModelTableIsiPlaylist;
import Model.Lagu.DAOLagu;
import Model.Lagu.InterfaceDAOLagu;
import Model.Lagu.ModelLagu;
import Model.Lagu.ModelTableLagu;
import View.HalamanIsiPlaylist;

import java.util.List;

public class ControllerIsiPlaylist {
    List<ModelLagu> daftarLagu;
    List<ModelIsiPlaylist> daftarIsiPlaylist;
    InterfaceDAOIsiPlaylistLagu daoIsiPlaylist;
    InterfaceDAOLagu daoLagu;
    HalamanIsiPlaylist halamanIsiPlaylist;


    public ControllerIsiPlaylist(HalamanIsiPlaylist halamanIsiPlaylist) {
        this.daoLagu = new DAOLagu();
        this.halamanIsiPlaylist = halamanIsiPlaylist;
        this.daoIsiPlaylist = new DAOIsiPlaylist();
    }

    public void tampilkanDaftarIsiPlaylist(int idPlaylist) {

        daftarIsiPlaylist = daoIsiPlaylist.showIsiPlaylist(idPlaylist);
        ModelTableIsiPlaylist modelTableIsiPlaylist = new ModelTableIsiPlaylist(daftarIsiPlaylist);
        halamanIsiPlaylist.getTableIsiPlaylist().setModel(modelTableIsiPlaylist);

    }

    public void tampilkanDaftarLagu() {
        daftarLagu = daoLagu.getAllLagu();
        ModelTableLagu modelTableLagu = new ModelTableLagu(daftarLagu);
        halamanIsiPlaylist.getTableListLagu().setModel(modelTableLagu);
    }

    public void deleteLagu(int id) {

        if (id != -1) {
            System.out.println("ID Isi Playlist: " + id);
            daoIsiPlaylist.deleteLagu(id);
        } else {
            System.out.println("Pilih lagu yang ingin dihapus dari playlist.");
        }
    }

    public void insertLagu(int idPlaylist, int idLagu) {
        if (idPlaylist != -1 && idLagu != -1) {

            // Cek apakah lagu sudah ada di playlist sebelum insert
            boolean exists = daftarIsiPlaylist != null && daftarIsiPlaylist.stream()
                    .anyMatch(isi -> isi.getIdLagu() == idLagu);

            if (exists) {
                System.out.println("Lagu sudah ada di playlist.");
            } else {
                System.out.println("ID Playlist: " + idPlaylist + ", ID Lagu: " + idLagu);
                ModelIsiPlaylist isiPlaylist = new ModelIsiPlaylist();
                isiPlaylist.setIdPlaylist(idPlaylist);
                isiPlaylist.setIdLagu(idLagu);
                daoIsiPlaylist.insertLagu(isiPlaylist);
                tampilkanDaftarIsiPlaylist(idPlaylist);
            }
        } else {
            System.out.println("Pilih playlist dan lagu yang ingin ditambahkan.");
        }
    }

}
