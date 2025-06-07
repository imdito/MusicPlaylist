package Model;
import java.sql.*;

public class ConnectDatabase {

    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "playlist_musik";
    private static String url_db = "jdbc:mysql://localhost:3306/" + nama_db;
    private static String username_db = "root";
    private static String pass_db = "";

    static Connection conn;
    public static Connection Connect(){

        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(url_db, username_db, pass_db);
            System.out.println("Mysql Connected");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Connection Failed!" + e);

        }

        return conn;

    }

}
