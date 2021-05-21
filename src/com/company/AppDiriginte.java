package com.company;

import Obiecte.*;
import Servicii.CitireConcursuri;
import Servicii.DeleteBD;
import Servicii.LoadBD;
import Servicii.UpdateBD;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class AppDiriginte {
    private JPanel panelDirig;
    private JLabel nameDirig;
    private JList list1;
    private JButton logoutButton;
    private JTextArea optionShowText;
    private JLabel clasaDirig;
    private JTextArea textClasaDirig;

    public JPanel getPanelDirig() {
        return panelDirig;
    }

    public AppDiriginte(String nume, JFrame frame) throws SQLException {

        frame.setSize(1200,700);
        panelDirig.setVisible(true);
        nameDirig.setText(nume);

        // Initializari
        LoadBD loadBD = new LoadBD();

        Profesor[] profesori = new Profesor[10];
        loadBD.loadProfesori(profesori);

        ArrayList<Concursuri> concursuri = new ArrayList<>(3);
        CitireConcursuri read1 = CitireConcursuri.getInstance();
        read1.citire("src\\Fisiere\\Concursuri.csv", concursuri, 3);


        Diriginte[] diriginti = new Diriginte[4];
        loadBD.loadDiriginti(diriginti);

        ArrayList<Materie> materii = new ArrayList<>(14);
        loadBD.loadMaterii(materii,profesori,diriginti);

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
        loadBD.loadElevi(elevi,materii,note,absente,concursuri);

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

        if(nume.equals(clasa1.getDiriginte().getNume()+" "+clasa1.getDiriginte().getPrenume()))
        {
            clasaDirig.setText(clasa1.getDenumire());
            textClasaDirig.setText(clasa1.afisare());
        }
        else
        if(nume.equals(clasa2.getDiriginte().getNume()+" "+clasa2.getDiriginte().getPrenume()))
        {
            clasaDirig.setText(clasa2.getDenumire());
            textClasaDirig.setText(clasa2.afisare());
        }
        else
        if(nume.equals(clasa3.getDiriginte().getNume()+" "+clasa3.getDiriginte().getPrenume()))
        {
            clasaDirig.setText(clasa3.getDenumire());
            textClasaDirig.setText(clasa3.afisare());
        }
        else
        if(nume.equals(clasa4.getDiriginte().getNume()+" "+clasa4.getDiriginte().getPrenume()))
        {
            clasaDirig.setText(clasa4.getDenumire());
            textClasaDirig.setText(clasa4.afisare());
        }
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int[] selectedIx = list1.getSelectedIndices();
                Object sel = null;
                for (int ix : selectedIx) {
                    sel = list1.getModel().getElementAt(ix);
                }

                assert sel != null;
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

                        String result;
                        if (n == 0) {
                            result = "Medie liceului Dinicu Golescu este : " + liceu1.mediaPeLiceu();
                        } else {
                            result = "Medie liceului Dan Barbilian este : " + liceu2.mediaPeLiceu();
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }


                    case 2 -> {

                        Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                        int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);

                        Object[] options1 = {"a XII-a A", "a XII-a B"};
                        int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options1,
                                options1[1]);
                        if (n == 0) {
                            String result;
                            if (n1 == 0) {
                                result = "Cea mai mare medie din " + clasa1.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa();
                            } else {
                                result = "Cea mai mare medie din " + clasa2.getDenumire() + ": " + clasa2.ceaMaiMareMedieClasa();
                            }
                            optionShowText.setText(null);
                            optionShowText.setText(result);
                        } else {
                            String result;
                            if (n1 == 0) {
                                result = "Cea mai mare medie din " + clasa3.getDenumire() + ": " + clasa3.ceaMaiMareMedieClasa();
                            } else {
                                result = "Cea mai mare medie din " + clasa4.getDenumire() + ": " + clasa4.ceaMaiMareMedieClasa();
                            }
                            optionShowText.setText(null);
                            optionShowText.setText(result);
                        }
                    }


                    case 3 -> {
                        Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                        int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);

                        String result;
                        if (n == 0) {
                            result = "Cea mai mare medie din " + liceu1.getDenumire_liceu() + " :" + liceu1.ceaMaiMareMedieLiceu();
                        } else {
                            result = "Cea mai mare medie din " + liceu2.getDenumire_liceu() + " :" + liceu2.ceaMaiMareMedieLiceu();
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);
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
                        int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                options1,
                                options1[1]);
                        String s = (String) JOptionPane.showInputDialog(null, "Top cat doriti? Introduceti un numar:", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                null,
                                "3");
                        if (n == 0) {
                            if (n1 == 0) {
                                if ((s != null) && (s.length() > 0)) {
                                    int topN = Integer.parseInt(s);
                                    String result = clasa1.ceiMaiBuniElevi(topN);
                                    optionShowText.setText(null);
                                    optionShowText.append(result);
                                }
                            } else {
                                if ((s != null) && (s.length() > 0)) {
                                    int topN = Integer.parseInt(s);
                                    String result = clasa1.ceiMaiBuniElevi(topN);
                                    optionShowText.setText(null);
                                    optionShowText.append(result);
                                }

                            }
                        } else {
                            if (n1 == 0) {
                                if ((s != null) && (s.length() > 0)) {
                                    int topN = Integer.parseInt(s);
                                    String result = clasa1.ceiMaiBuniElevi(topN);
                                    optionShowText.setText(null);
                                    optionShowText.append(result);
                                }

                            } else {
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

                        String result;
                        if (n == 0) {
                            result = "Cel mai chiulangiu elev din liceul " + liceu1.getDenumire_liceu() + ", este " + liceu1.celMaiCiulangiu(liceu1).getNume() + " " + liceu1.celMaiCiulangiu(liceu1).getPrenume() + ", avand  " + liceu1.celMaiCiulangiu(liceu1).absenteElev() + " absente";
                        } else {
                            result = "Cel mai chiulangiu elev din liceul " + liceu2.getDenumire_liceu() + ", este " + liceu2.celMaiCiulangiu(liceu2).getNume() + " " + liceu2.celMaiCiulangiu(liceu2).getPrenume() + ", avand  " + liceu2.celMaiCiulangiu(liceu2).absenteElev() + " absente";
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }

                    case 8 -> {
                        Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                        int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);

                        String result;
                        if (n == 0) {
                            result = liceu1.corigentii(liceu1);
                        } else {
                            result = liceu2.corigentii(liceu2);
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }

                    case 9 -> {
                        Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                        int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);

                        Object[] options1 = {"a XII-a A", "a XII-a B"};
                        int n1 = JOptionPane.showOptionDialog(null, "Pentru ce clasa doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options1,
                                options1[1]);
                        if (n == 0) {
                            String result;
                            if (n1 == 0) {
                                result = clasa1.detaliiClasa();

                            } else {
                                result = clasa2.detaliiClasa();
                            }
                            optionShowText.setText(null);
                            optionShowText.setText(result);
                        } else {
                            String result;
                            if (n1 == 0) {
                                result = clasa3.detaliiClasa();
                            } else {
                                result = clasa4.detaliiClasa();
                            }
                            optionShowText.setText(null);
                            optionShowText.setText(result);
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

                        String result;
                        if (n == 0) {
                            result = liceu1.eleviOlimpici();
                        } else {
                            result = liceu2.eleviOlimpici();
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);
                    }


                    case 12 -> {
                        Object[] options = {"Dinicu Golescu", "Dan Barbilian"};
                        int n = JOptionPane.showOptionDialog(null, "Pentru ce liceu doriti?", "Ask", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);

                        String result;
                        if (n == 0) {
                            result = liceu1.afisare();
                        } else {
                            result = liceu2.afisare();
                        }
                        optionShowText.setText(null);
                        optionShowText.setText(result);

                    }

                    case 13 -> {
                        if (nume.equals(clasa1.getDiriginte().getNume() + " " + clasa1.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa1.getElevi().length];
                            for (int i = 0; i < clasa1.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");

                            char c1 = opt.charAt(0);
                            int n = Character.getNumericValue(c1);
                            System.out.println(n + 1);
                            DeleteBD deleteBD = new DeleteBD();
                            deleteBD.deleteElev(n + 1);
                            JOptionPane.showMessageDialog(null, "Elev sters cu succes!");
                            try {
                                panelDirig.setVisible(false);
                                frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        } else if (nume.equals(clasa2.getDiriginte().getNume() + " " + clasa2.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa2.getElevi().length];
                            for (int i = 0; i < clasa2.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");

                            char c1 = opt.charAt(0);
                            int n = Character.getNumericValue(c1);
                            System.out.println(n + 1);
                            DeleteBD deleteBD = new DeleteBD();
                            deleteBD.deleteElev(n + 1);
                            JOptionPane.showMessageDialog(null, "Elev sters cu succes!");
                            try {
                                panelDirig.setVisible(false);
                                frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        } else if (nume.equals(clasa3.getDiriginte().getNume() + " " + clasa3.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa3.getElevi().length];
                            for (int i = 0; i < clasa3.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");

                            char c1 = opt.charAt(0);
                            int n = Character.getNumericValue(c1);
                            System.out.println(n + 1);
                            DeleteBD deleteBD = new DeleteBD();
                            deleteBD.deleteElev(n + 1);
                            JOptionPane.showMessageDialog(null, "Elev sters cu succes!");
                            try {
                                panelDirig.setVisible(false);
                                frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        } else if (nume.equals(clasa4.getDiriginte().getNume() + " " + clasa4.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa4.getElevi().length];
                            for (int i = 0; i < clasa4.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");

                            char c1 = opt.charAt(0);
                            int n = Character.getNumericValue(c1);
                            System.out.println(n + 1);
                            DeleteBD deleteBD = new DeleteBD();
                            deleteBD.deleteElev(n + 1);
                            JOptionPane.showMessageDialog(null, "Elev sters cu succes!");
                            try {
                                panelDirig.setVisible(false);
                                frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }

                    }

                    case 14 -> {
                        UpdateBD updateBD = new UpdateBD();

                        if (nume.equals(clasa1.getDiriginte().getNume() + " " + clasa1.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa1.getElevi().length];
                            for (int i = 0; i < clasa1.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-i introduceti un concurs", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");

                            char c1 = opt.charAt(0);
                            int id = Character.getNumericValue(c1);

                            String[] elements1 = new String[concursuri.size()];
                            for (int i = 0; i < concursuri.size(); ++i)
                                elements1[i] = i + ": " + concursuri.get(i).getDenumire();
                            String op1 = (String) JOptionPane.showInputDialog(null, "La ce concurs a participat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements1,
                                    "concurs");

                            String idConcurs = op1.substring(0,1);

                            String premiu = (String) JOptionPane.showInputDialog(null, "Ce premiu a luat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    null,
                                    "3");
                            if ((premiu != null) && (premiu.length() > 0)) {

                                updateBD.updateElev(id+1, idConcurs, premiu);
                                JOptionPane.showMessageDialog(null, "Informatie actualizatat cu succes!");
                                try {
                                    panelDirig.setVisible(false);
                                    frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }

                        } else if (nume.equals(clasa2.getDiriginte().getNume() + " " + clasa2.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa2.getElevi().length];
                            for (int i = 0; i < clasa2.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");
                            char c1 = opt.charAt(0);
                            int id = Character.getNumericValue(c1);

                            String[] elements1 = new String[concursuri.size()];
                            for (int i = 0; i < concursuri.size(); ++i)
                                elements1[i] = i + ": " + concursuri.get(i).getDenumire();
                            String op1 = (String) JOptionPane.showInputDialog(null, "La ce concurs a participat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements1,
                                    "concurs");

                            String idConcurs = op1.substring(0,1);


                            String premiu = (String) JOptionPane.showInputDialog(null, "Ce premiu a luat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    null,
                                    "3");
                            if ((premiu != null) && (premiu.length() > 0)) {

                                updateBD.updateElev(id+1, idConcurs, premiu);
                                JOptionPane.showMessageDialog(null, "Informatie actualizatat cu succes!");
                                try {
                                    panelDirig.setVisible(false);
                                    frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }

                        } else if (nume.equals(clasa3.getDiriginte().getNume() + " " + clasa3.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa3.getElevi().length];
                            for (int i = 0; i < clasa3.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "concurs");
                            char c1 = opt.charAt(0);
                            int id = Character.getNumericValue(c1);

                            String[] elements1 = new String[concursuri.size()];
                            for (int i = 0; i < concursuri.size(); ++i)
                                elements1[i] = i+ ": " + concursuri.get(i).getDenumire();
                            String op1 = (String) JOptionPane.showInputDialog(null, "La ce concurs a participat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements1,
                                    "concurs");

                            String idConcurs = op1.substring(0,1);


                            String premiu = (String) JOptionPane.showInputDialog(null, "Ce premiu a luat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    null,
                                    "3");
                            if ((premiu != null) && (premiu.length() > 0)) {

                                updateBD.updateElev(id+1, idConcurs, premiu);
                                JOptionPane.showMessageDialog(null, "Informatie actualizatat cu succes!");
                                try {
                                    panelDirig.setVisible(false);
                                    frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }

                        } else if (nume.equals(clasa4.getDiriginte().getNume() + " " + clasa4.getDiriginte().getPrenume())) {
                            String[] elements = new String[clasa4.getElevi().length];
                            for (int i = 0; i < clasa4.getElevi().length; ++i)
                                elements[i] = i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume();
                            String opt = (String) JOptionPane.showInputDialog(null, "Alegi un elev pentru care doriti sa-l stergeti", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements,
                                    "elev");
                            char c1 = opt.charAt(0);
                            int id = Character.getNumericValue(c1);

                            String[] elements1 = new String[concursuri.size()];
                            for (int i = 0; i < concursuri.size(); ++i)
                                elements1[i] = i + ": " + concursuri.get(i).getDenumire();
                            String op1 = (String) JOptionPane.showInputDialog(null, "La ce concurs a participat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    elements1,
                                    "concurs");

                            String idConcurs = op1.substring(0,1);


                            String premiu = (String) JOptionPane.showInputDialog(null, "Ce premiu a luat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                    null,
                                    "3");
                            if ((premiu != null) && (premiu.length() > 0)) {

                                updateBD.updateElev(id+1, idConcurs, premiu);
                                JOptionPane.showMessageDialog(null, "Informatie actualizatat cu succes!");
                                try {
                                    panelDirig.setVisible(false);
                                    frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        }
                    }

                    case 15 ->{
                        UpdateBD updateBD = new UpdateBD();

                        String[] elements = new String[materii.size()];
                        for (int i = 0; i < materii.size(); ++i)
                            elements[i] = i + ": " + materii.get(i).getNume_materie();
                        String opt = (String) JOptionPane.showInputDialog(null, "Alegi o materie pe care doritit sa o midificati", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                elements,
                                "materie");

                        char c1 = opt.charAt(0);
                        int id = Character.getNumericValue(c1);

                        String[] elements1 = new String[profesori.length];
                        for (int i = 0; i < profesori.length; ++i)
                            elements1[i] = i + ": " + profesori[i].getNume()+" "+profesori[i].getPrenume();
                        String opt1 = (String) JOptionPane.showInputDialog(null, "La ce concurs a participat?", "Ask", JOptionPane.PLAIN_MESSAGE, null,
                                elements1,
                                "concurs");

                        char idProf = opt1.charAt(0);
                        int idProfesor = Character.getNumericValue(idProf);

                        try {
                            updateBD.updateMaterie(id+1, idProfesor);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Informatie actualizatat cu succes!");
                        try {
                            panelDirig.setVisible(false);
                            frame.setContentPane(new AppDiriginte(nume, frame).getPanelDirig());
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                    case 16 -> {
                            StringBuilder result = new StringBuilder(materii.get(0).getNume_materie() + "\n");
                       for( int i = 1; i < materii.size();++i)
                            result.append(materii.get(i).getNume_materie()).append("\n");

                       optionShowText.setText(null);
                       optionShowText.setText(result.toString());
                    }
                }
            }
        });

        logoutButton.addActionListener(e -> {
            panelDirig.setVisible(false);
            frame.setContentPane(new App().getRootPanel());
            frame.setSize(400,500);
        });
    }
}
