package Model.IsiPlaylist;

import Model.ConnectDatabase;
import Model.Lagu.ModelLagu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOIsiPlaylist implements InterfaceDAOIsiPlaylistLagu{


    @Override
    public void insertLagu(ModelIsiPlaylist isiPlaylist) {
        try {
            String query = "INSERT INTO `playlist_lagu` (`id_playlist`, `id_lagu`) VALUES(?,?);";

            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, isiPlaylist.getIdPlaylist());
            statement.setInt(2, isiPlaylist.getIdLagu());
            statement.executeUpdate();
            statement.close();

        }catch (SQLException e){
            System.out.println("Error Insert Lagu to Playlist: " + e.getMessage());
        }
    }

    @Override
    public void deleteLagu(int idIsiPlaylist) {
        try {
            String query = "DELETE FROM `playlist_lagu` WHERE `id` = ?;";
            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, idIsiPlaylist);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Delete Lagu from Playlist: " + e.getMessage());
        }
    }

    @Override
    public List<ModelIsiPlaylist> showIsiPlaylist(int idPlaylist) {
        List<ModelIsiPlaylist> list = new ArrayList<>();
        try {
            String query = "SELECT playlist_lagu.id, lagu.judul, lagu.penyanyi, lagu.genre FROM playlist_lagu INNER JOIN lagu on playlist_lagu.id_lagu = lagu.id WHERE playlist_lagu.id_playlist = ?;";
            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, idPlaylist);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                ModelIsiPlaylist isiPlaylist = new ModelIsiPlaylist();
                isiPlaylist.setIdIsiPlaylist(resultSet.getInt("id"));
                isiPlaylist.setJudulLagu(resultSet.getString("judul"));
                isiPlaylist.setPenyanyi(resultSet.getString("penyanyi"));
                isiPlaylist.setGenre(resultSet.getString("genre"));
                list.add(isiPlaylist);
            }
            statement.close();
            // Logic to handle the result set can be added here
        } catch (SQLException e) {
            System.out.println("Error Show Isi Playlist: " + e.getMessage());
        }
        return list;
    }
}
