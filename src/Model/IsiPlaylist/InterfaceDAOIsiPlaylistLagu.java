package Model.IsiPlaylist;

import java.util.List;

public interface InterfaceDAOIsiPlaylistLagu {

    public void insertLagu(ModelIsiPlaylist isiPlaylist);
    public void deleteLagu(int idIsiPlaylist);
    public List<ModelIsiPlaylist> showIsiPlaylist(int idPlaylist);

}
