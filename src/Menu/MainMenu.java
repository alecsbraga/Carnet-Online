package Menu;

import Obiecte.*;
import Servicii.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    public void apelare() throws InterruptedException {
        //Initializari
        CitireProfesori read0 = CitireProfesori.getInstance();
        Profesor[] profesori = new Profesor[10];
        read0.citire("src\\Fisiere\\Profesori.csv", profesori, 10);

        CitireConcursuri read1 = CitireConcursuri.getInstance();
        ArrayList<Concursuri> concursuri = new ArrayList<>(3);
        read1.citire("src\\Fisiere\\Concursuri.csv", concursuri, 3);


        CitireDiriginti read2 = CitireDiriginti.getInstance();
        Diriginte[] diriginti = new Diriginte[4];
        read2.citire("src\\Fisiere\\Diriginti.csv", diriginti, 4);

        CitireMaterii read3 = CitireMaterii.getInstance();
        ArrayList<Materie> materii = new ArrayList<>(14);
        read3.citire("src\\Fisiere\\Materii.csv", materii, profesori, diriginti, 14);


        int[][] note = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                note[i][j]= ThreadLocalRandom.current().nextInt(4,  10);
            }
        }

        int[][] absente = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                absente[i][j]= ThreadLocalRandom.current().nextInt(0,  4);
            }
        }

        Director director1= new Director("Parghel","Ion");
        Director director2= new Director("Zaharia","Dan");

        CitireElevi read4 = CitireElevi.getInstance();
        Elev[] elevi = new Elev[40];
        read4.citire("src\\Fisiere\\Elevi.csv", elevi, materii, note, absente, concursuri,40);

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

        Liceu liceu1 = new Liceu("Dinicu Golescu",director1,clase1);
        Liceu liceu2 = new Liceu("Dan Barbilian",director2,clase2);

        //Apeluri pentru cele 12 actiunii sau meniul
        System.out.println("------------------------------------------------------------");
        System.out.println("--------------Va rugam sa alegeti optiune-------------------");
        System.out.println("1: Afisare media unui liceu");
        System.out.println("2: Cea mai mare medie dintr-o clasa dintr-un liceu");
        System.out.println("3: Cea mai mare medie dintr-un liceu");
        System.out.println("4: Numarul total de absente ale unui elev");
        System.out.println("5: Top n cei mai buni elevi dintr-o clasa");
        System.out.println("6: Top n cei mai bunielevi dintr-un liceu");
        System.out.println("7: Cel mai chiulangiu elev dintr-un liceu");
        System.out.println("8: Elevi corigenti dintr-un liceu");
        System.out.println("9: Detalii depsre o clasa");
        System.out.println("10: Situatia unui elev");
        System.out.println("11: Elevii olimpici dintr-un liceu");
        System.out.println("12: Informatii despre elevii dintr-un liceu");
        System.out.println("13: Adaugare elev");
        System.out.println("14: Exit");
        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.print("Tastati numarul optiunii: ");
        Scanner scanner = new Scanner(System.in);
        int optiune = scanner.nextInt();
        do {
            if (optiune == 13)
                System.exit(0);
            else if (optiune > 13){
                System.out.println("Optiune gresita/ nu exista. Alegeti alta sau tastati 13 pentru a inchide");
                System.out.print("Tastati numarul optiunii: ");
                optiune = scanner.nextInt();}
        }while(optiune >= 14);

        do {
            switch (optiune) {

                case 1 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune1 = scanner.nextInt();
                    if (optiune1 == 1) {
                        System.out.println("Medie liceului Dinicu Golescu este : " + liceu1.mediaPeLiceu());
                    } else {
                        System.out.println("Medie liceului Dinicu Golescu este : " + liceu2.mediaPeLiceu());
                    }
                    System.out.println();
                }

                case 2 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune2 = scanner.nextInt();
                    System.out.println();
                    System.out.println("Pentru ce clasa doriti?");
                    System.out.println("1: a XII-a A");
                    System.out.println("2: a XII-a B");
                    System.out.print("Introduceti numarul:");
                    int optiune2_1 = scanner.nextInt();
                    if (optiune2 == 1) {
                        if (optiune2_1 == 1)
                            System.out.println("Cea mai mare medie din " + clasa1.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa());
                        else
                            System.out.println("Cea mai mare medie din " + clasa2.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa());

                    } else {
                        if (optiune2_1 == 1)
                            System.out.println("Cea mai mare medie din " + clasa3.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa());
                        else
                            System.out.println("Cea mai mare medie din " + clasa4.getDenumire() + ": " + clasa1.ceaMaiMareMedieClasa());
                    }
                    System.out.println();
                }

                case 3 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune3 = scanner.nextInt();
                    if (optiune3 == 1)
                        System.out.println("Cea mai mare medie din " + liceu1.getDenumire_liceu() + " :" + liceu1.ceaMaiMareMedieLiceu());

                    else
                        System.out.println("Cea mai mare medie din " + liceu2.getDenumire_liceu() + " :" + liceu2.ceaMaiMareMedieLiceu());
                    System.out.println();
                }

                case 4 -> {
                    System.out.println();
                    System.out.println("Alegi un elev pentru care doriti sa aflati numarul de absente");
                    for (int i = 0; i < 40; ++i)
                        System.out.println(i + ": " + elevi[i].getNume()+" "+elevi[i].getNume());
                    System.out.print("Introduceti numarul elevului:");
                    int optiune4 = scanner.nextInt();
                    System.out.println("Numarul total de absente ale elevului " + elevi[optiune4].getNume() + " " + elevi[optiune4].getPrenume() + " sunt: " + elevi[optiune4].absenteElev());
                    System.out.println();
                }

                case 5 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune5 = scanner.nextInt();
                    System.out.println();
                    System.out.println("Pentru ce clasa doriti?");
                    System.out.println("1: a XII-a A");
                    System.out.println("2: a XII-a B");
                    System.out.print("Introduceti numarul:");
                    int optiune5_1 = scanner.nextInt();
                    System.out.print("Top cat doriti? Introduceti un numar:");
                    int n = scanner.nextInt();
                    if (optiune5 == 1) {
                        if (optiune5_1 == 1)
                            clasa1.ceiMaiBuniElevi(n);
                        else
                            clasa2.ceiMaiBuniElevi(n);

                    } else {
                        if (optiune5_1 == 1)
                            clasa3.ceiMaiBuniElevi(n);
                        else
                            clasa4.ceiMaiBuniElevi(n);
                    }
                    System.out.println();
                }

                case 6 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune6 = scanner.nextInt();
                    System.out.println();
                    System.out.print("Top cat doriti? Introduceti un numar:");
                    int n = scanner.nextInt();
                    if (optiune6 == 1) {
                        liceu1.ceiMaiBuniElevi(n);

                    } else {
                            liceu2.ceiMaiBuniElevi(n);
                    }
                    System.out.println();
                }

                case 7 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune7 = scanner.nextInt();
                    if (optiune7 == 1) {
                        System.out.println("Cel mai chiulangiu elev din liceul "+ liceu1.getDenumire_liceu()+ ", este " + liceu1.celMaiCiulangiu(liceu1).getNume()+" "+ liceu1.celMaiCiulangiu(liceu1).getPrenume()+", avand  "+liceu1.celMaiCiulangiu(liceu1).absenteElev()+" absente");

                    } else {
                        System.out.println("Cel mai chiulangiu elev din liceul "+ liceu2.getDenumire_liceu()+ ", este " + liceu2.celMaiCiulangiu(liceu2).getNume()+" "+ liceu2.celMaiCiulangiu(liceu2).getPrenume()+", avand  "+liceu2.celMaiCiulangiu(liceu2).absenteElev()+" absente");
                    }
                    System.out.println();
                }

                case 8 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune8 = scanner.nextInt();
                    if (optiune8 == 1) {
                        liceu1.corigentii(liceu2);

                    } else {
                        liceu2.corigentii(liceu2);
                    }
                    System.out.println();
                }

                case 9 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune9 = scanner.nextInt();
                    System.out.println();
                    System.out.println("Pentru ce clasa doriti?");
                    System.out.println("1: a XII-a A");
                    System.out.println("2: a XII-a B");
                    System.out.print("Introduceti numarul:");
                    int optiune9_1 = scanner.nextInt();
                    System.out.print("Top cat doriti? Introduceti un numar:");
                    if (optiune9 == 1) {
                        if (optiune9_1 == 1)
                            clasa1.detaliiClasa();
                        else
                            clasa2.detaliiClasa();
                    } else {
                        if (optiune9_1 == 1)
                            clasa3.detaliiClasa();
                        else
                            clasa4.detaliiClasa();
                    }
                    System.out.println();
                }

                case 10 -> {
                    System.out.println();
                    System.out.println("Alegi un elev pentru care doriti sa aflati informatii");
                    for (int i = 0; i < 40; ++i)
                        System.out.println(i + ": " + elevi[i].getNume()+" "+elevi[i].getPrenume());
                    System.out.print("Introduceti numarul elevului:");
                    int optiune10 = scanner.nextInt();
                    elevi[optiune10].Afisare();
                    System.out.println();
                }

                case 11 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune11 = scanner.nextInt();
                    if (optiune11 == 1) {
                        liceu1.eleviOlimpici();

                    } else {
                        liceu2.eleviOlimpici();
                    }
                    System.out.println();
                }

                case 12 -> {
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune12 = scanner.nextInt();
                    if (optiune12 == 1) {
                        liceu1.afisare();

                    } else {
                        liceu2.afisare();
                    }
                    System.out.println();
                }
                case 13 -> {
                    System.out.println();
                    System.out.println("Introduceti numele elevului ");
                    String nume = scanner.nextLine();
                    System.out.println("Introduceti prenumele elevului ");
                    String prenume = scanner.nextLine();
                    System.out.println("Introduceti data de nastere a elevului ");
                    String data = scanner.nextLine();
                    int[] notenew = new int[14];
                    int[] absentenew = new int [14];
                    for(int i=0; i<14; ++i){
                         System.out.println("Ce media si cate absente are elevul pe care doriti sa-l introduceti la materia "+ materii.get(i).getNume_materie() );
                         int nota = scanner.nextInt();
                         notenew[i]=nota;
                         int absenta = scanner.nextInt();
                         absentenew[i]=absenta;
                    }
                    System.out.println("Elevul pe care doriti sa-l introduceti este olimpic?");
                    System.out.println("Daca da, tastati 1, daca nu, tastati 2");
                    int optionconcurs = scanner.nextInt();
                    if(optionconcurs == 2) {
                        Elev elevNew = new Elev(nume, prenume, data, materii, notenew, absentenew);
                    }
                   // else{
                        /// daca este olimpic
                  //  }
                    // se va scrie in fisierul elevilor dupa ce va fi asignat intr-o clasa si un liceu
                }

            }
                    TimeUnit.MILLISECONDS.sleep(3000);
                    System.out.println("Doritii sa alegeti si alte optiunii?");
                    System.out.println("1: Da");
                    System.out.println("2: Nu");
                    System.out.print("Introduceti numarul:");
                    int optiune13 = scanner.nextInt();
                    if (optiune13 == 1) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("--------------Va rugam sa alegeti optiune-------------------");
                        System.out.println("1: Afisare media unui liceu");
                        System.out.println("2: Cea mai mare medie dintr-o clasa");
                        System.out.println("3: Cea mai mare medie dintr-un liceu");
                        System.out.println("4: Numarul total de absente ale unui elev");
                        System.out.println("5: Top n cei mai buni elevi dintr-o clasa");
                        System.out.println("6: Top n cei mai bunielevi dintr-un liceu");
                        System.out.println("7: Cel mai chiulangiu elev dintr-un liceu");
                        System.out.println("8: Elevi corigenti dintr-un liceu");
                        System.out.println("9: Detalii depsre o clasa");
                        System.out.println("10: Situatia unui elev");
                        System.out.println("11: Elevii olimpici dintr-un liceu");
                        System.out.println("12: Informatii despre elevii dintr-un liceu");
                        System.out.println("13: Adaugare elev");
                        System.out.println("14: Exit");
                        System.out.println("------------------------------------------------------------");
                        System.out.print("Tastati numarul optiunii: ");
                        optiune = scanner.nextInt();
                    } else {
                        System.exit(0);
                    }



            }while (optiune <= 14);
        System.exit(0);
    }
}
