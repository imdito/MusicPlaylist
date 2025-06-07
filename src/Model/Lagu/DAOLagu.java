package Model.Lagu;

import Model.ConnectDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLagu implements InterfaceDAOLagu{


    @Override
    public void insertLagu(ModelLagu lagu) {
        try{

            String query = "INSERT INTO `lagu` (`judul`, `penyanyi`, `album`, `genre`, `gambar`, `link`) VALUES (?, ? , ? ,? , ?, ?);";

            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setString(1, lagu.getJudulLagu());
            statement.setString(2, lagu.getPenyanyi());
            statement.setString(3, lagu.getAlbum());
            statement.setString(4, lagu.getGenre());
            statement.setString(5, lagu.getGambar());
            statement.setString(6, lagu.getLinkLagu());
            statement.executeUpdate();
            statement.close();

        }catch (SQLException e) {
            System.out.println("Error Add Lagu: " + e.getMessage());
        }
    }

    @Override
    public void deleteLagu(int idLagu) {
        try {
            System.out.println("Deleting Lagu with ID: " + idLagu);
            String query = "DELETE FROM `lagu` WHERE `id` = ?;";
            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setInt(1, idLagu);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Delete Lagu: " + e.getMessage());
        }
    }

    @Override
    public List<ModelLagu> getAllLagu() {
        List<ModelLagu> listLagu = new ArrayList<>();
        try {
            String query = "SELECT * FROM `lagu`;";
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModelLagu lagu = new ModelLagu();
                lagu.setIdLagu(resultSet.getInt("id"));
                lagu.setJudulLagu(resultSet.getString("judul"));
                lagu.setPenyanyi(resultSet.getString("penyanyi"));
                lagu.setAlbum(resultSet.getString("album"));
                lagu.setGenre(resultSet.getString("genre"));
                lagu.setGambar(resultSet.getString("gambar"));
                lagu.setLinkLagu(resultSet.getString("link"));
                listLagu.add(lagu);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Get All Lagu: " + e.getMessage());
        }
        return listLagu;
    }

    @Override
    public void updateLagu(ModelLagu lagu) {
        try {
            String query = "UPDATE `lagu` SET `judul` = ?, `penyanyi` = ?, `album` = ?, `genre` = ?, `gambar` = ?, `link` = ? WHERE `id` = ?;";
            PreparedStatement statement;
            statement = ConnectDatabase.Connect().prepareStatement(query);
            statement.setString(1, lagu.getJudulLagu());
            statement.setString(2, lagu.getPenyanyi());
            statement.setString(3, lagu.getAlbum());
            statement.setString(4, lagu.getGenre());
            statement.setString(5, lagu.getGambar());
            statement.setString(6, lagu.getLinkLagu());
            statement.setInt(7, lagu.getIdLagu());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error Update Lagu: " + e.getMessage());
        }
    }


}
