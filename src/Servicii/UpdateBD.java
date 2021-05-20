package Servicii;

import Obiecte.Elev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBD {
    String databaseName = "carnet_online";
    String url = "jdbc:mysql://localhost:3306/"+databaseName;
    String username = "root";
    String password = "alecs2972";

    public void updateMaterie(int id, int id_profesor) throws SQLException {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "update MATERII set id_profesor="+ id_profesor +" where id="+id;
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateElev(Elev[] elevi, int id, String idConcurs, String premiu){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "update ELEVI set idConcurs="+ idConcurs +" premiu="+ premiu +" where id="+id;
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
