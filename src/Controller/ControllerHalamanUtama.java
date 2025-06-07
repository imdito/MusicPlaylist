package Controller;

import Model.IsiPlaylist.InterfaceDAOIsiPlaylistLagu;
import Model.Lagu.DAOLagu;
import Model.Lagu.InterfaceDAOLagu;
import Model.Lagu.ModelLagu;
import Model.Lagu.ModelTableLagu;
import Model.PlayList.DAOPlaylist;
import Model.PlayList.InterfacePlaylistLagu;
import Model.PlayList.ModelPlaylist;
import Model.PlayList.ModelTablePlaylist;
import View.HalamanUtama;

import java.util.List;

public class ControllerHalamanUtama {

    HalamanUtama halamanUtama;
    InterfaceDAOLagu daoLagu;
    InterfacePlaylistLagu daoPlaylistLagu;

    List<ModelLagu> daftarLagu;
    List<ModelPlaylist> daftarPlaylist;


    public ControllerHalamanUtama(HalamanUtama halamanTable) {
        this.halamanUtama = halamanTable;
        this.daoLagu = new DAOLagu();
        this.daoPlaylistLagu = new DAOPlaylist();
    }

    public void tampilkanDaftarLagu() {
        daftarLagu = daoLagu.getAllLagu();
        ModelTableLagu modelTableLagu = new ModelTableLagu(daftarLagu);

        halamanUtama.getTableLagu().setModel(modelTableLagu);
    }

    public void tampilkanDaftarPlaylist() {
        daftarPlaylist = daoPlaylistLagu.getAllPlaylists();
        ModelTablePlaylist modelTablePlaylist = new ModelTablePlaylist(daftarPlaylist);
        halamanUtama.getTablePlaylist().setModel(modelTablePlaylist);
    }

}


