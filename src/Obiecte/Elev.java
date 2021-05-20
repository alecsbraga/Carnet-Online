package Obiecte;

import java.util.ArrayList;

public class Elev {
    private String nume;
    private String prenume;
    private String data_nastere;
    private ArrayList<Materie> materii;
    protected int[] medii;
    protected int[] absente;
    private Concursuri concursuri;
    private int premiu;

    public Elev(String nume, String prenume, String data_nastere, ArrayList<Materie> materii, int[] medii, int[] absente, Concursuri concursuri, int premiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nastere = data_nastere;
        this.materii = materii;
        this.medii = medii;
        this.absente = absente;
        this.concursuri = concursuri;
        this.premiu = premiu;
    }

    public Elev(String nume, String prenume, String data_nastere, ArrayList<Materie> materii, int[] medii, int[] absente) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nastere = data_nastere;
        this.materii = materii;
        this.medii = medii;
        this.absente = absente;
    }

    public Elev() {
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Concursuri getConcursuri() {
        return concursuri;
    }

    public int[] getMedii() {
        return medii;
    }

    public String Afisare() {
        StringBuilder result = new StringBuilder(nume + ", " + prenume + ", " + data_nastere + ", ");

        for(int i=0;i< materii.size();++i){
            result.append(materii.get(i).getNume_materie()).append(" media:").append(medii[i]).append(", absente:").append(absente[i]).append("; ");
        }
        if(concursuri != null)
        {
             result.append(concursuri.getDenumire()).append(", ").append(premiu);
        }
        result.append("\n");
        return result.toString();
    }

    public float medieElev()
    {
        float medie = 0f;
        for (int j : medii) {
            medie += j;
        }
        return medie/14;
    }
    public int absenteElev(){
        int suma_absente = 0;
        for (int j : absente) {
            suma_absente += j;
        }
        return suma_absente;
    }

    public String olimpic(){
        String result = "";
        if(premiu <= 3)
            result = "Elevul "+ nume +" "+prenume+" este olimpic la "+ concursuri.getDenumire()+", etapa "+ concursuri.getEtapa()+", cu premiul "+ premiu;
        return result;
    }
}

