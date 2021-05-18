package Servicii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBD {
    String databaseName = "carnet_online";
    String url = "jdbc:mysql://localhost:3306/"+databaseName;
    String username = "root";
    String password = "alecs2972";

    public void deleteElev(int id)
    {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "delete from ELEVI where id="+ id +";";
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

