package Obiecte;

public class Elev {
    private String nume;
    private String prenume;
    private String data_nastere;
    private Materie[] materii;
    protected int[] medii;
    protected int[] absente;
    private Concursuri concursuri;
    private int premiu;

    public Elev(String nume, String prenume, String data_nastere, Materie[] materii, int[] medii, int[] absente, Concursuri concursuri, int premiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nastere = data_nastere;
        this.materii = materii;
        this.medii = medii;
        this.absente = absente;
        this.concursuri = concursuri;
        this.premiu = premiu;
    }

    public Elev(String nume, String prenume, String data_nastere, Materie[] materii, int[] medii, int[] absente) {
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

    public void Afisare() {
        System.out.println(nume+", "+prenume+", "+data_nastere+", ");
        for(int i=0;i< materii.length;++i){
            System.out.print(materii[i].getNume_materie()+" media:"+medii[i]+", absente:"+absente[i]+"; ");
        }
        if(concursuri != null)
        {
            concursuri.Afisare();
            System.out.print(", "+premiu);
        }
        System.out.println();
    }

    public float medie_elev()
    {
        float medie = 0f;
        for(int i=1;i<medii.length;++i) {
            medie += medii[i];
        }
        return medie/14;
    }
    public int absente_elev(){
        int suma_absente = 0;
        for (int j : absente) {
            suma_absente += j;
        }
        return suma_absente;
    }

    public void olimpic(){
        if(premiu <= 3)
        System.out.println("Elevul "+ nume +" "+prenume+" este olimpic la "+ concursuri.getDenumire()+", etapa "+ concursuri.getEtapa()+", cu premiul "+ premiu);
    }
}

