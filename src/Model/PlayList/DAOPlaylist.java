package Model.PlayList;

import Model.ConnectDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPlaylist implements InterfacePlaylistLagu{

    @Override
    public void createPlaylist(ModelPlaylist playlist) {
        System.out.println("Creating Playlist: " + playlist.getNamePlaylist() + " for User ID: " + playlist.getIdUser());
        try {
            System.out.println("Adding Playlist: " + playlist.getNamePlaylist() + " for User ID: " + playlist.getIdUser());

            String query = "INSERT INTO `playlist` (`nama`, `id_user`) VALUES (?, ?);";
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setString(1, playlist.getNamePlaylist());
            statement.setInt(2, playlist.getIdUser());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Addd Playlist: " + e.getMessage());
        }
    }

    @Override
    public void deletePlaylist(int idPlaylist) {
        try {
            String query = "DELETE FROM `playlist` WHERE `id` = ?";
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, idPlaylist);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Delete Playlist: " + e.getMessage());
        }
    }

    @Override
    public void updatePlaylist(ModelPlaylist playlist) {
        try {
            String query = "UPDATE `playlist` SET `nama` = ? WHERE `id` = ?;";
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setString(1, playlist.getNamePlaylist());
            statement.setInt(2, playlist.getIdPlaylist());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Update Playlist: " + e.getMessage());
        }
    }

    @Override
    public List<ModelPlaylist> getAllPlaylists(int idUser) {
        List<ModelPlaylist> listplaylists = new ArrayList<>();
        try {
            String query = "SELECT * FROM `playlist` WHERE `id_user` = ?;";
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, idUser);
             // Assuming you want to filter by user ID
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModelPlaylist playlist = new ModelPlaylist();
                playlist.setIdPlaylist(resultSet.getInt("id"));
                playlist.setNamePlaylist(resultSet.getString("nama"));
                listplaylists.add(playlist);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Fetching Playlists: " + e.getMessage());
        }
        return  listplaylists;
    }
}
