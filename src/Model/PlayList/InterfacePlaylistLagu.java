package Model.PlayList;

import Model.ConnectDatabase;

import java.util.List;

public interface InterfacePlaylistLagu {

    public void createPlaylist(ModelPlaylist playlist);
    public void deletePlaylist(int idPlaylist);
    public void updatePlaylist(ModelPlaylist playlist);
    public List<ModelPlaylist> getAllPlaylists(int idUser);
}
