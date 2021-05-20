package Menu;

import Obiecte.Clasa;
import Obiecte.Elev;
import Obiecte.Liceu;
import Servicii.Audit;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu implements Audit{
    public void apelare(Liceu liceu1, Liceu liceu2, Clasa clasa1, Clasa clasa2, Clasa clasa3, Clasa clasa4, Elev[] elevi) throws InterruptedException {

        System.out.println("------------------------------------------------------------");
        System.out.println("--------------Va rugam sa alegeti o optiune-------------------");
        System.out.println("1: Afisare media unui liceu");
        System.out.println("2: Cea mai mare medie dintr-o clasa dintr-un liceu");
        System.out.println("3: Cea mai mare medie dintr-un liceu");
        System.out.println("4: Numarul total de absente ale unui elev");
        System.out.println("5: Top n cei mai buni elevi dintr-o clasa");
        System.out.println("6: Top n cei mai buni elevi dintr-un liceu");
        System.out.println("7: Cel mai chiulangiu elev dintr-un liceu");
        System.out.println("8: Elevi corigenti dintr-un liceu");
        System.out.println("9: Detalii despre o clasa");
        System.out.println("10: Situatia unui elev");
        System.out.println("11: Elevii olimpici dintr-un liceu");
        System.out.println("12: Informatii despre elevii dintr-un liceu");
        System.out.println("13: Exit");
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
        }while(optiune >= 13);

        do {
            switch (optiune) {

                case 1 -> {
                    audit("Afisare media unui liceu");
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune1 = scanner.nextInt();
                    if (optiune1 == 1) {
                        System.out.println("Medie liceului Dinicu Golescu este : " + liceu1.mediaPeLiceu());
                    } else {
                        System.out.println("Medie liceului Dan Barbilian este : " + liceu2.mediaPeLiceu());
                    }
                    System.out.println();
                }

                case 2 -> {
                    audit("Cea mai mare medie dintr-o clasa dintr-un liceu");
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
                            System.out.println("Cea mai mare medie din " + clasa2.getDenumire() + ": " + clasa2.ceaMaiMareMedieClasa());

                    } else {
                        if (optiune2_1 == 1)
                            System.out.println("Cea mai mare medie din " + clasa3.getDenumire() + ": " + clasa3.ceaMaiMareMedieClasa());
                        else
                            System.out.println("Cea mai mare medie din " + clasa4.getDenumire() + ": " + clasa4.ceaMaiMareMedieClasa());
                    }
                    System.out.println();
                }

                case 3 -> {
                    audit("Cea mai mare medie dintr-un liceu");
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
                    audit("Numarul total de absente ale unui elev");
                    System.out.println();
                    System.out.println("Alegi un elev pentru care doriti sa aflati numarul de absente");
                    for (int i = 0; i < 40; ++i)
                        System.out.println(i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume());
                    System.out.print("Introduceti numarul elevului:");
                    int optiune4 = scanner.nextInt();
                    System.out.println("Numarul total de absente ale elevului " + elevi[optiune4].getNume() + " " + elevi[optiune4].getPrenume() + " sunt: " + elevi[optiune4].absenteElev());
                    System.out.println();
                }

                case 5 -> {
                    audit("Top n cei mai buni elevi dintr-o clasa");
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
                            System.out.print(clasa1.ceiMaiBuniElevi(n));
                        else
                            System.out.print(clasa2.ceiMaiBuniElevi(n));

                    } else {
                        if (optiune5_1 == 1)
                            System.out.print(clasa3.ceiMaiBuniElevi(n));
                        else
                            System.out.print(clasa4.ceiMaiBuniElevi(n));
                    }
                    System.out.println();
                }

                case 6 -> {
                    audit("Top n cei mai bunielevi dintr-un liceu");
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
                        System.out.println(liceu1.ceiMaiBuniElevi(n));

                    } else {
                        System.out.println(liceu2.ceiMaiBuniElevi(n));
                    }
                    System.out.println();
                }

                case 7 -> {
                    audit("Cel mai chiulangiu elev dintr-un liceu");
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune7 = scanner.nextInt();
                    if (optiune7 == 1) {
                        System.out.println("Cel mai chiulangiu elev din liceul " + liceu1.getDenumire_liceu() + ", este " + liceu1.celMaiCiulangiu(liceu1).getNume() + " " + liceu1.celMaiCiulangiu(liceu1).getPrenume() + ", avand  " + liceu1.celMaiCiulangiu(liceu1).absenteElev() + " absente");

                    } else {
                        System.out.println("Cel mai chiulangiu elev din liceul " + liceu2.getDenumire_liceu() + ", este " + liceu2.celMaiCiulangiu(liceu2).getNume() + " " + liceu2.celMaiCiulangiu(liceu2).getPrenume() + ", avand  " + liceu2.celMaiCiulangiu(liceu2).absenteElev() + " absente");
                    }
                    System.out.println();
                }

                case 8 -> {
                    audit("Elevi corigenti dintr-un liceu");
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune8 = scanner.nextInt();
                    if (optiune8 == 1) {
                        System.out.println(liceu1.corigentii(liceu1));

                    } else {
                        System.out.println(liceu2.corigentii(liceu2));
                    }
                    System.out.println();
                }

                case 9 -> {
                    audit("Detalii despre o clasa");
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
                    if (optiune9 == 1) {
                        if (optiune9_1 == 1)
                            System.out.println(clasa1.detaliiClasa());
                        else
                            System.out.println(clasa2.detaliiClasa());
                    } else {
                        if (optiune9_1 == 1)
                            System.out.println(clasa3.detaliiClasa());
                        else
                            System.out.println(clasa4.detaliiClasa());
                    }
                    System.out.println();
                }

                case 10 -> {
                    audit("Situatia unui elev");
                    System.out.println();
                    System.out.println("Alegi un elev pentru care doriti sa aflati informatii");
                    for (int i = 0; i < 40; ++i)
                        System.out.println(i + ": " + elevi[i].getNume() + " " + elevi[i].getPrenume());
                    System.out.print("Introduceti numarul elevului:");
                    int optiune10 = scanner.nextInt();
                    System.out.print(elevi[optiune10].Afisare());
                    System.out.println();
                }

                case 11 -> {
                    audit("Elevii olimpici dintr-un liceu");
                    System.out.println();
                    System.out.println("Pentru ce liceu doriti?");
                    System.out.println("1: Dinicu Golescu");
                    System.out.println("2: Dan Barbilian");
                    System.out.print("Introduceti numarul:");
                    int optiune11 = scanner.nextInt();
                    if (optiune11 == 1) {
                        System.out.print(liceu1.eleviOlimpici());

                    } else {
                        System.out.println(liceu2.eleviOlimpici());
                    }
                    System.out.println();
                }

                case 12 -> {
                    audit("Informatii despre elevii dintr-un liceu");
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

            }
                    TimeUnit.MILLISECONDS.sleep(3000);
                    System.out.println("Doritii sa alegeti si alte optiunii?");
                    System.out.println("1: Da");
                    System.out.println("2: Nu");
                    System.out.print("Introduceti numarul:");
                    int optiune13 = scanner.nextInt();
                    if (optiune13 == 1) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("--------------Va rugam sa alegeti o optiune-------------------");
                        System.out.println("1: Afisare media unui liceu");
                        System.out.println("2: Cea mai mare medie dintr-o clasa");
                        System.out.println("3: Cea mai mare medie dintr-un liceu");
                        System.out.println("4: Numarul total de absente ale unui elev");
                        System.out.println("5: Top n cei mai buni elevi dintr-o clasa");
                        System.out.println("6: Top n cei mai buni elevi dintr-un liceu");
                        System.out.println("7: Cel mai chiulangiu elev dintr-un liceu");
                        System.out.println("8: Elevi corigenti dintr-un liceu");
                        System.out.println("9: Detalii despre o clasa");
                        System.out.println("10: Situatia unui elev");
                        System.out.println("11: Elevii olimpici dintr-un liceu");
                        System.out.println("12: Informatii despre elevii dintr-un liceu");
                        System.out.println("13: Exit");
                        System.out.println("------------------------------------------------------------");
                        System.out.print("Tastati numarul optiunii: ");
                        optiune = scanner.nextInt();
                    } else {
                        System.exit(0);
                    }

            }while (optiune < 13);
        System.exit(0);
    }
}
