package com.company;

import Obiecte.*;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        //Initializari

        Profesor profesor1 = new Profesor("Heroiu", "Bogdan");
        Profesor profesor2 = new Profesor("Tatulea", "Maria");
        Profesor profesor3 = new Profesor("Calinescu", "Ion");
        Profesor profesor4 = new Profesor("Marinescu", "Andrei");
        Profesor profesor5 = new Profesor("Coviu", "Ionut");
        Profesor profesor6 = new Profesor("Fistea", "Vasile");
        Profesor profesor7 = new Profesor("Iordache", "Nelu");
        Profesor profesor8 = new Profesor("Neluta", "Andrei");
        Profesor profesor9 = new Profesor("Marianche", "Florin");
        Profesor profesor10 = new Profesor("Giugiu", "Vlad");

        Diriginte diriginte1=new Diriginte("Oarga","Cornel");
        Diriginte diriginte2=new Diriginte("Negusi","Andreea");
        Diriginte diriginte3=new Diriginte("Stanciu","Mihaela");
        Diriginte diriginte4=new Diriginte("Tonciu","Monica");

        Materie materie1 = new Materie("Matematica",profesor1);
        Materie materie2 = new Materie("Fizica", diriginte1);
        Materie materie3 = new Materie("Informatica", profesor2);
        Materie materie4 = new Materie("Romana",profesor3);
        Materie materie5 = new Materie("Chimie",profesor4);
        Materie materie6 = new Materie("Geografie",profesor5);
        Materie materie7 = new Materie("Biologie",profesor6);
        Materie materie8 = new Materie("Engleza",profesor7);
        Materie materie9 = new Materie("Franceza",profesor8);
        Materie materie10 = new Materie("Istorie",profesor9);
        Materie materie11 = new Materie("Matematica",profesor10);
        Materie materie12 = new Materie("Informatica",diriginte2);
        Materie materie13 = new Materie("Romana",diriginte3);
        Materie materie14 = new Materie("Fizica",diriginte4);

        Materie[] materii= {materie1,materie2,materie3,materie4,materie5,materie6,materie7,materie8,materie9,materie10,materie11,materie12,materie13,materie14};

        int[][] note = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                note[i][j]= ThreadLocalRandom.current().nextInt(4,  10);
            }
        }

        int[][] absente = new int[41][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                absente[i][j]= ThreadLocalRandom.current().nextInt(0,  4);
            }
        }

        Director director1= new Director("Parghel","Ion");
        Director director2= new Director("Zaharia","Dan");

        Concursuri concursuri1 = new Concursuri("Olipiana de informatica","Etapa Natioanala","Dinicu Golescu");
        Concursuri concursuri2 = new Concursuri("Olipiana de matematica","Etapa Natioanala","Dan Barbilian");
        Concursuri concursuri3 = new Concursuri("Olipiana de fizica","Etapa Natioanala","Dinicu Golescu");

        Elev elev1 = new Elev("Braga","Alecsandru","02-07-2000",materii,note[0],absente[0],concursuri1, 1);
        Elev elev2 = new Elev("Gava","Bogdan","12-09-2000",materii,note[1],absente[1],concursuri2,3);
        Elev elev3 = new Elev("Racasean","Ivona","12-02-2000",materii,note[2],absente[2]);
        Elev elev4 = new Elev("Moise","George","03-01-2000",materii,note[3],absente[3]);
        Elev elev5 = new Elev("Achimescu","Ionut","22-10-2000",materii,note[4],absente[4]);
        Elev elev6 = new Elev("Motrun","Mihai","02-10-2000",materii,note[5],absente[5]);
        Elev elev7 = new Elev("Achim","Gabriel","11-03-2000",materii,note[6],absente[6]);
        Elev elev8 = new Elev("Arvatu","Andreea","06-04-2000",materii,note[7],absente[7]);
        Elev elev9 = new Elev("Butnariu","Beti","22-08-2000",materii,note[8],absente[8]);
        Elev elev10 = new Elev("Dumitru","Andrei","01-12-2000",materii,note[9],absente[9]);
        Elev elev11 = new Elev("Negusi","Andrei","11-02-2000",materii,note[10],absente[10]);
        Elev elev12 = new Elev("Vadim","Tudor","18-12-2000",materii,note[11],absente[11]);
        Elev elev13 = new Elev("Marcelas","Ionut","20-01-2000",materii,note[12],absente[12]);
        Elev elev14 = new Elev("Maroon","Five","22-02-2000",materii,note[13],absente[13]);
        Elev elev15 = new Elev("Fercus","Alin","21-02-2000",materii,note[14],absente[14]);
        Elev elev16 = new Elev("Balau","Alexandru","30-03-2000",materii,note[15],absente[15]);
        Elev elev17 = new Elev("Ganci","Andrei","02-04-2000",materii,note[16],absente[16]);
        Elev elev18 = new Elev("Vramescu","Costinela","12-05-2000",materii,note[17],absente[17]);
        Elev elev19 = new Elev("Nelut","Ioana","18-06-2000",materii,note[18],absente[18]);
        Elev elev20 = new Elev("Tenusi","Andreea","16-07-2000",materii,note[19],absente[19]);
        Elev elev21 = new Elev("Popescu","Eduard","15-07-2000",materii,note[20],absente[20]);
        Elev elev22 = new Elev("Ologu","Catinca","14-08-2000",materii,note[21],absente[21],concursuri2,4);
        Elev elev23 = new Elev("Vole","Andrei","13-09-2000",materii,note[22],absente[22]);
        Elev elev24 = new Elev("Valimareanu","Andrei","12-10-2000",materii,note[23],absente[23]);
        Elev elev25 = new Elev("Bodea","Silviu","12-11-2000",materii,note[24],absente[24]);
        Elev elev26 = new Elev("Gavril","Lorin","20-12-2000",materii,note[25],absente[25]);
        Elev elev27 = new Elev("Tudorache","Alexandra","28-11-2000",materii,note[26],absente[26]);
        Elev elev28 = new Elev("Costache","Andrei","28-10-2000",materii,note[27],absente[27]);
        Elev elev29 = new Elev("Antonescu","Ion","26-09-2000",materii,note[28],absente[28]);
        Elev elev30 = new Elev("Scarlatescu","George","23-08-2000",materii,note[29],absente[29]);
        Elev elev31 = new Elev("Nelesceanu","Marcel","01-07-2000",materii,note[30],absente[30]);
        Elev elev32 = new Elev("Teguci","Florin","08-06-2000",materii,note[31],absente[31]);
        Elev elev33 = new Elev("Iancescu","Eric","19-05-2000",materii,note[32],absente[32]);
        Elev elev34 = new Elev("Marcelascu","Vasile","16-03-2000",materii,note[33],absente[33]);
        Elev elev35 = new Elev("Paunescu","Ilona","02-04-2000",materii,note[34],absente[34]);
        Elev elev36 = new Elev("Panaite","Vladut","13-02-2000",materii,note[35],absente[35]);
        Elev elev37 = new Elev("Tekasi","Alex","29-10-2000",materii,note[36],absente[36]);
        Elev elev38 = new Elev("Avram","Robert","28-01-2000",materii,note[37],absente[37]);
        Elev elev39 = new Elev("Valcu","Mihai","20-12-2000",materii,note[38],absente[38],concursuri3,2);
        Elev elev40 = new Elev("Sonescu","Ionut","01-11-2000",materii,note[39],absente[39]);


        Elev[] elevi1= {elev1,elev2,elev3,elev4,elev5,elev6,elev7,elev8,elev9,elev10};
        Elev[] elevi2= {elev11,elev12,elev13,elev14,elev15,elev16,elev17,elev18,elev19,elev20};
        Elev[] elevi3= {elev21,elev22,elev23,elev24,elev25,elev26,elev27,elev28,elev29,elev30};
        Elev[] elevi4= {elev31,elev32,elev33,elev34,elev35,elev36,elev37,elev38,elev39,elev40};


        Clasa clasa1 = new Clasa("a XII-a A",elevi1,diriginte1,"Matematica-Informatica");
        Clasa clasa2 = new Clasa("a XII-a B",elevi2,diriginte2,"Matematica-Informatica");
        Clasa clasa3 = new Clasa("a XII-a A",elevi3,diriginte3,"Filologie");
        Clasa clasa4 = new Clasa("a XII-a B",elevi4,diriginte4,"Filologie");

        Clasa[] clase1={clasa1,clasa2};
        Clasa[] clase2={clasa3,clasa4};

        Liceu liceu1 = new Liceu("Dinicu Golescu",director1,clase1);
        Liceu liceu2 = new Liceu("Dan Barbilian",director2,clase2);

        //Apeluri pentru cele 10 actiunii

        //1.media notelor unui liceu
        System.out.println("Medie liceului Dinicu Golescu este : "+liceu2.media_pe_liceu());
        System.out.println();

        //2.cea mai mare medie dintr-o clasa
        System.out.println("Cea mai mare medie din "+clasa1.getDenumire() +": "+ clasa1.cea_mai_mare_medie_clasa());
        System.out.println();

        //3.cea mai mare medie dintr-un liceu
        System.out.println("Cea mai mare medie din "+liceu2.getDenumire_liceu()+" :"+liceu2.cea_mai_mare_medie_liceu());
        System.out.println();

        //4.numarul total de absente ale unui elev
        System.out.println("Numarul total de absente ale elevului "+ elev1.getNume()+" "+elev1.getPrenume()+" sunt: "+elev1.absente_elev());
        System.out.println();

        //5.top n cei mai buni elevi dintr-o clasa
        clasa1.cei_mai_buni_elevi(4); // top 4 cei mai buni elevi dintr-o clasa
        System.out.println();

        //6.top n cei mai buni elevi dintr-un liceu
        liceu2.cei_mai_buni_elevi(4);
        System.out.println();

        //7.cel mai chiulangiu elevi dintr-un liceu
        System.out.println("Cel mai chiulangiu elev din liceul "+ liceu1.getDenumire_liceu()+ ", este " + liceu1.cel_mai_ciulangiu(liceu1).getNume()+" "+ liceu1.cel_mai_ciulangiu(liceu1).getPrenume()+", avand  "+liceu1.cel_mai_ciulangiu(liceu1).absente_elev()+" absente");
        System.out.println();

        //8.afisare elevi corigenti dintr-un liceu
        liceu2.corigentii(liceu2);
        System.out.println();

        //9.pentru o clasa se va afisa dirigintele, numarul de elevi, media si numarul total de absente
        clasa1.detalii_clasa();
        System.out.println();

        //10.situatia unui elev dupa nume
        elev1.Afisare();
        System.out.println();

        //11.afisare  elevi olimpici dintr-un liceu (care e in top3 la un concurs)
        liceu1.elevi_olimpici();
        System.out.println();

        //12.se va afisa toti elevii dintr-un liceu cu mediile pentru fiecare materie
        liceu1.Afisare();
        System.out.println();
    }
}
