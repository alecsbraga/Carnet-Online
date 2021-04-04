package Obiecte;

import Servicii.Afisare;

import java.util.Arrays;
import java.util.Comparator;

public class Clasa implements Afisare {
    final private String denumire;
    final private Elev[] elevi;
    final private Diriginte diriginte;
    final private String profil;

    public Clasa(String denumire, Elev[] elevi, Diriginte diriginte, String profil) {
        this.denumire = denumire;
        this.elevi = elevi;
        this.diriginte = diriginte;
        this.profil = profil;
    }

    public String getDenumire() {
        return denumire;
    }

    public Elev[] getElevi() {
        return elevi;
    }

    @Override
    public void afisare() {
        System.out.println(denumire+", "+profil+", "+diriginte.getNume());
        System.out.println();
        for (Elev elev : elevi) {
            elev.Afisare();
        }
    }

    public float mediePeClasa(){
        float medie = 0f;
        for (Elev elev : elevi) {
            medie += elev.medieElev();
        }
        return medie/9;
    }

    public void detaliiClasa() {
        int total_absente = 0;
        for (Elev elev : elevi) total_absente += elev.absenteElev();
        System.out.println("Pentru clasa"+denumire+" , avem diriginte pe "+diriginte.getNume()+" "+diriginte.getPrenume()+",, cu un numar de "+elevi.length+" elevi, media pe clasa:"+ mediePeClasa()+" , si un numar total de absente de "+total_absente);

    }

    public float ceaMaiMareMedieClasa(){
        float maxim = 0f;
        for (Elev elev : elevi) {
            if (elev.medieElev() > maxim) {
                maxim = elev.medieElev();
            }
        }
        return maxim;
    }
    @Override
    public void ceiMaiBuniElevi(int n) {
        Arrays.sort(elevi, new Comparator<Elev>() {
            @Override
            public int compare(Elev o1, Elev o2) {
                if(o1.medieElev() > o2.medieElev())
                    return -1;
                if(o1.medieElev() < o2.medieElev())
                return 1;
                    return 0;
            }
        });
        for( int i=0;i<n;++i)
        {
            System.out.println((i+1)+". "+elevi[i].getNume()+" "+elevi[i].getPrenume()+", media: "+elevi[i].medieElev() );
        }
    }
}
