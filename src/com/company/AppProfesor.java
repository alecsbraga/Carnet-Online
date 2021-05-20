package com.company;

import Obiecte.*;
import Servicii.CitireBD;
import Servicii.CitireConcursuri;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class AppProfesor {
    private JPanel panelProf;
    private JLabel nameProf;
    private JList list1;
    private JButton logoutButton;
    private JTextArea optionShowText;

    public JPanel getPanelProf() {
        return panelProf;
    }

    public AppProfesor(String nume, JFrame frame) throws SQLException {

        frame.setSize(800,400);

        nameProf.setText(nume);

        // Initializari
        CitireBD citireBD = new CitireBD();

        Profesor[] profesori = new Profesor[10];
        citireBD.citireProfesori(profesori);

        ArrayList<Concursuri> concursuri = new ArrayList<>(3);
        CitireConcursuri read1 = CitireConcursuri.getInstance();
        read1.citire("src\\Fisiere\\Concursuri.csv", concursuri, 3);


        Diriginte[] diriginti = new Diriginte[4];
        citireBD.citireDiriginti(diriginti);

        ArrayList<Materie> materii = new ArrayList<>(14);
        citireBD.citireMaterii(materii,profesori,diriginti);

        int[][] note = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                note[i][j]= ThreadLocalRandom.current().nextInt(7,  10);
            }
        }

        int[][] absente = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                absente[i][j]= ThreadLocalRandom.current().nextInt(0,  4);
            }
        }


        Elev[] elevi = new Elev[40];
        citireBD.citireElevi(elevi,materii,note,absente,concursuri);

        Elev[] elevi1 = Arrays.copyOfRange(elevi,0,10);
        Elev[] elevi2 = Arrays.copyOfRange(elevi,10,20);
        Elev[] elevi3 = Arrays.copyOfRange(elevi,20,30);
        Elev[] elevi4 = Arrays.copyOfRange(elevi,30,40);

        Clasa clasa1 = new Clasa("a XII-a A",elevi1,diriginti[0],"Matematica-Informatica");
        Clasa clasa2 = new Clasa("a XII-a B",elevi2,diriginti[1],"Matematica-Informatica");
        Clasa clasa3 = new Clasa("a XII-a A",elevi3,diriginti[2],"Filologie");
        Clasa clasa4 = new Clasa("a XII-a B",elevi4,diriginti[3],"Filologie");

        Clasa[] clase1={clasa1,clasa2};
        Clasa[] clase2={clasa3,clasa4};

        Director director1= new Director("Parghel","Ion");
        Director director2= new Director("Zaharia","Dan");

        Liceu liceu1 = new Liceu("Dinicu Golescu",director1,clase1);
        Liceu liceu2 = new Liceu("Dan Barbilian",director2,clase2);


        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int[] selectedIx = list1.getSelectedIndices();
                Object sel = null;
                for (int ix : selectedIx) {
                    sel = list1.getModel().getElementAt(ix);
                }

                char c = sel.toString().charAt(0);
                char cx = sel.toString().charAt(1);
                String sir;
                int optiune;
                if( Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) <= 9 && cx =='.'){
                   optiune = Character.getNumericValue(c);
                }
                else
                {
                    sir = sel.toString().substring(0,2);
                    optiune = Integer.parseInt(sir);
                }

                System.out.println(optiune);
        switch (optiune) {
            case 1 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = "Medie liceului Dinicu Golescu este : " + liceu1.mediaPeLiceu();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = "Medie liceului Dan Barbilian este : " + liceu2.mediaPeLiceu();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }
            }


            case 2 -> {

                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                Object[] options1 = {"a XII-a A", "a XII-a B"};
                if (n == 0) {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String result = "Cea mai mare medie din " + clasa1.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    } else {
                        String result = "Cea mai mare medie din " + clasa2.getDenumire() + ": " + clasa2.ceaMaiMareMedieClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }
                } else {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String result = "Cea mai mare medie din " + clasa3.getDenumire() + ": " + clasa3.ceaMaiMareMedieClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    } else {
                        String result = "Cea mai mare medie din " + clasa4.getDenumire() + ": " + clasa4.ceaMaiMareMedieClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }
                }
            }


            case 3 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = "Cea mai mare medie din " + liceu1.getDenumire_liceu() + " :" + liceu1.ceaMaiMareMedieLiceu();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = "Cea mai mare medie din " + liceu2.getDenumire_liceu() + " :" + liceu2.ceaMaiMareMedieLiceu();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }
            }
            case 4 -> {

                String[] elements = new String[elevi.length];
                for (int i = 0; i < elevi.length; ++i)
                    elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();

                String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa aflati numarul de absente", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                        elements,
                        "elev");

                char c1 = opt.charAt(0);
                int n = Character.getNumericValue(c1);

                String result = "Numarul total de absente ale elevului " + elevi[n].getNume() + " " + elevi[n].getPrenume() + " sunt: " + elevi[n].absenteElev();
                optionShowText.setText(null);
                optionShowText.setText(result);
            }

            case 5 -> {

                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                Object[] options1 = {"a XII-a A", "a XII-a B"};
                if (n == 0) {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = clasa1.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }
                    } else {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = clasa1.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }

                    }
                } else {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = clasa1.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }

                    } else {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = clasa1.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }
                    }
                }
            }


            case 6 -> {

                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = liceu1.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }
                    }
                } else {
                    {
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if ((s != null) && (s.length() > 0)) {
                            int topN = Integer.parseInt(s);
                            String result = liceu2.ceiMaiBuniElevi(topN);
                            optionShowText.setText(null);
                            optionShowText.append(result);
                        }
                    }
                }
            }

            case 7 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = "Cel mai chiulangiu elev din liceul " + liceu1.getDenumire_liceu() + ", este " + liceu1.celMaiCiulangiu(liceu1).getNume() + " " + liceu1.celMaiCiulangiu(liceu1).getPrenume() + ", avand  " + liceu1.celMaiCiulangiu(liceu1).absenteElev() + " absente";
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = "Cel mai chiulangiu elev din liceul " + liceu2.getDenumire_liceu() + ", este " + liceu2.celMaiCiulangiu(liceu2).getNume() + " " + liceu2.celMaiCiulangiu(liceu2).getPrenume() + ", avand  " + liceu2.celMaiCiulangiu(liceu2).absenteElev() + " absente";
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }
            }

            case 8 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = liceu1.corigentii(liceu1);
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = liceu2.corigentii(liceu2);
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }
            }

            case 9 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                Object[] options1 = {"a XII-a A", "a XII-a B"};
                if (n == 0) {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String result = clasa1.detaliiClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);

                    } else {
                        String result = clasa2.detaliiClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }
                } else {
                    int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null,
                            options1,
                            options1[1]);
                    if (n1 == 0) {
                        String result = clasa3.detaliiClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    } else {
                        String result = clasa4.detaliiClasa();
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }
                }
            }

            case 10 -> {
                String[] elements = new String[elevi.length];
                for (int i = 0; i < elevi.length; ++i)
                    elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();

                String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa aflati informatii", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                        elements,
                        "elev");

                char c1 = opt.charAt(0);
                int n = Character.getNumericValue(c1);
                String result = elevi[n].Afisare();
                optionShowText.setText(null);
                optionShowText.setText(result);

            }

            case 11 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = liceu1.eleviOlimpici();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = liceu2.eleviOlimpici();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }
            }


            case 12 -> {
                Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

                if (n == 0) {
                    String result = liceu1.afisare();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                } else {
                    String result = liceu2.afisare();
                    optionShowText.setText(null);
                    optionShowText.setText(result);
                }

            }

        }
            }
        });

        logoutButton.addActionListener(e -> {
            panelProf.setVisible(false);
            frame.setContentPane(new App().getRootPanel());
            frame.setSize(400,500);
        });
    }
}
