package Servicii;

import Obiecte.*;

import java.sql.*;
import java.util.ArrayList;

public class LoadBD {
    String databaseName = "carnet_online";
    String url = "jdbc:mysql://localhost:3306/"+databaseName;
    String username = "root";
    String password = "alecs2972";

    public void loadElevi(Elev[] elevi, ArrayList<Materie> materii, int[][] note, int[][] absente, ArrayList<Concursuri> concursuri){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from ELEVI";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = -1;
            while(res.next()){
                String nume = res.getString("nume");
                String prenume = res.getString("prenume");
                String dataNastere = res.getString("dataNastere");
                int idArrayNote = res.getInt("idArrayNote");
                int idArrayAbsente = res.getInt("idArrayAbsente");
                String idConcurs = res.getString("idConcurs");
                String premiu = res.getString("premiu");
                ++i;
                if(!idConcurs.equals("-") && !premiu.equals("-")){
                    elevi[i]= new Elev(nume,prenume,dataNastere,materii, note[idArrayNote],absente[idArrayAbsente], concursuri.get(Integer.parseInt(idConcurs)),Integer.parseInt(premiu));
                }
                else {
                    elevi[i]= new Elev(nume,prenume,dataNastere,materii, note[idArrayNote],absente[idArrayAbsente]);
                }
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loadDiriginti (Diriginte[] diriginti) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from DIRIGINTI";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = -1;
            while(res.next()){
                String nume = res.getString("nume");
                String prenume = res.getString("prenume");
                ++i;
                diriginti[i]= new Diriginte(nume, prenume);
            }
            con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void loadProfesori (Profesor[] profesori) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from PROFESORI";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = -1;
            while(res.next()){
                String nume = res.getString("nume");
                String prenume = res.getString("prenume");
                ++i;
                profesori[i]= new Profesor(nume, prenume);
            }
            con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loadMaterii (ArrayList<Materie> materii, Profesor[] profesori, Diriginte[] diriginti) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from DIRIGINTI";
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = -1;
            while(res.next()){
                String numeMaterie = res.getString("nume_materi");
                int idProfesor = res.getInt("id_profesor");
                ++i;
                Materie materie;
                if(i <= 9){
                    materie = new Materie(numeMaterie, profesori[idProfesor]);
                }
                else{
                    materie = new Materie(numeMaterie, diriginti[idProfesor]);
                }
                materii.add(materie);
            }
            con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}