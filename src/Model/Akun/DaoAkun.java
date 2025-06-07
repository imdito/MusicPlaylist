package Model.Akun;

import Model.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoAkun implements InterfaceDAOAkun {



    @Override
    public void insertAkun(ModelAkun akun) {
        // Implementasi logika untuk menyimpan akun ke database
       try {
           PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(
               "INSERT INTO akun (username, password) VALUES (?, ?);");
                statement.setString(1, akun.getUsername());
                statement.setString(2, akun.getPassword());

                statement.executeUpdate();
                statement.close();
       } catch (Exception e) {
              System.out.println("Error Insert Akun: " + e.getMessage());
       }
    }

    @Override
    public boolean checkAkun(ModelAkun akun) {
        try {
            System.out.println(akun.getUsername());
            System.out.println("Checking Akun with Username: " + akun.getUsername() + " and Password: " + akun.getPassword());
            PreparedStatement statement = ConnectDatabase.Connect().prepareStatement(
                "SELECT * FROM akun WHERE username = ? AND password = ?;");
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.getString("username"));

            if (resultSet.next()) {
                System.out.println("Akun ditemukan");
                akun.setUsername(resultSet.getString("username"));
                akun.setPassword(resultSet.getString("password"));
                akun.setIdAkun(resultSet.getInt("id")); ;
                resultSet.close();
                return true;
            }            // Execute query and handle results as needed
            // For example, you might want to check if the result set is empty or not


        } catch (Exception e) {
            if(e.getMessage().equals("Illegal operation on empty result set.")){

                System.out.println("Error read Akun: " + e.getMessage());
                return false;

            }

        }
        return true;
    }

}
