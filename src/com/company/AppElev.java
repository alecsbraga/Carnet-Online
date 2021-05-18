package com.company;

import Obiecte.*;
import Servicii.CitireBD;
import Servicii.CitireConcursuri;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AppElev {
    private JPanel elevPanel;
    private JLabel nameElev;
    private JLabel mat1;
    private JLabel mat2;
    private JLabel mat3;
    private JLabel mat4;
    private JLabel mat5;
    private JLabel mat6;
    private JLabel mat7;
    private JLabel mat8;
    private JLabel mat9;
    private JLabel mat10;
    private JLabel mat11;
    private JLabel mat12;
    private JLabel mat13;
    private JLabel mat14;
    private JLabel nota1;
    private JLabel nota2;
    private JLabel nota3;
    private JLabel nota4;
    private JLabel nota5;
    private JLabel nota6;
    private JLabel nota7;
    private JLabel nota8;
    private JLabel nota9;
    private JLabel nota10;
    private JLabel nota11;
    private JLabel nota12;
    private JLabel nota13;
    private JLabel nota14;
    private JLabel medie;
    private JLabel abs1;
    private JLabel abs2;
    private JLabel abs3;
    private JLabel abs4;
    private JLabel abs5;
    private JLabel abs6;
    private JLabel abs7;
    private JLabel abs8;
    private JLabel abs9;
    private JLabel abs10;
    private JLabel abs11;
    private JLabel abs12;
    private JLabel abs13;
    private JLabel abs14;
    private JButton Logout;

    public JPanel getElevPanel() {
        return elevPanel;
    }

    public void initializari(Profesor[] profesori, ArrayList<Concursuri> concursuri, Diriginte[] diriginti,  ArrayList<Materie> materii, int[][] note,int[][] absente, Elev[] elevi )
    {
        CitireBD citireBD = new CitireBD();
        citireBD.citireProfesori(profesori);

        CitireConcursuri read1 = CitireConcursuri.getInstance();
        read1.citire("src\\Fisiere\\Concursuri.csv", concursuri, 3);

        citireBD.citireDiriginti(diriginti);

        citireBD.citireMaterii(materii,profesori,diriginti);

        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                note[i][j]= ThreadLocalRandom.current().nextInt(7,  10);
            }
        }

        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                absente[i][j]= ThreadLocalRandom.current().nextInt(0,  4);
            }
        }

        citireBD.citireElevi(elevi,materii,note,absente,concursuri);


    }

    public AppElev(String nume, JFrame frame) throws SQLException {

        frame.setSize(800,400);

        nameElev.setText(nume);

        Profesor[] profesori = new Profesor[10];
        Diriginte[] diriginti = new Diriginte[4];
        ArrayList<Materie> materii = new ArrayList<>(14);
        ArrayList<Concursuri> concursuri = new ArrayList<>(3);
        int[][] note = new int[40][14];
        int[][] absente = new int[40][14];
        Elev[] elevi = new Elev[40];
        initializari(profesori,concursuri,diriginti,materii,note,absente, elevi);

        mat1.setText(materii.get(0).getNume_materie());
        mat2.setText(materii.get(1).getNume_materie());
        mat3.setText(materii.get(2).getNume_materie());
        mat4.setText(materii.get(3).getNume_materie());
        mat5.setText(materii.get(4).getNume_materie());
        mat6.setText(materii.get(5).getNume_materie());
        mat7.setText(materii.get(6).getNume_materie());
        mat8.setText(materii.get(7).getNume_materie());
        mat9.setText(materii.get(8).getNume_materie());
        mat10.setText(materii.get(9).getNume_materie());
        mat11.setText(materii.get(10).getNume_materie());
        mat12.setText(materii.get(11).getNume_materie());
        mat13.setText(materii.get(12).getNume_materie());
        mat14.setText(materii.get(13).getNume_materie());
        int i = 0;
        for(int j=0; j<elevi.length; ++j) {
            if(elevi[j].getNume().equals(nume)){
                  i=j;
            }
        }
                nota1.setText(Integer.toString(note[i][0]));
                nota2.setText(Integer.toString(note[i][1]));
                nota3.setText(Integer.toString(note[i][2]));
                nota4.setText(Integer.toString(note[i][3]));
                nota5.setText(Integer.toString(note[i][4]));
                nota6.setText(Integer.toString(note[i][5]));
                nota7.setText(Integer.toString(note[i][6]));
                nota8.setText(Integer.toString(note[i][7]));
                nota9.setText(Integer.toString(note[i][8]));
                nota10.setText(Integer.toString(note[i][9]));
                nota11.setText(Integer.toString(note[i][10]));
                nota12.setText(Integer.toString(note[i][11]));
                nota13.setText(Integer.toString(note[i][12]));
                nota14.setText(Integer.toString(note[i][13]));

                abs1.setText(Integer.toString(absente[i][0]));
                abs2.setText(Integer.toString(absente[i][1]));
                abs3.setText(Integer.toString(absente[i][2]));
                abs4.setText(Integer.toString(absente[i][3]));
                abs5.setText(Integer.toString(absente[i][4]));
                abs6.setText(Integer.toString(absente[i][5]));
                abs7.setText(Integer.toString(absente[i][6]));
                abs8.setText(Integer.toString(absente[i][7]));
                abs9.setText(Integer.toString(absente[i][8]));
                abs10.setText(Integer.toString(absente[i][9]));
                abs11.setText(Integer.toString(absente[i][10]));
                abs12.setText(Integer.toString(absente[i][11]));
                abs13.setText(Integer.toString(absente[i][12]));
                abs14.setText(Integer.toString(absente[i][13]));

                medie.setText("Medie: "+ elevi[i].medieElev());

        Logout.addActionListener(e -> {
            elevPanel.setVisible(false);
            frame.setContentPane(new App().getRootPanel());
            frame.setSize(400,500);
        });
    }

}

