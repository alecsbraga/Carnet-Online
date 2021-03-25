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
    public void Afisare() {
        System.out.println(denumire+", "+profil+", "+diriginte.getNume());
        for (Elev elev : elevi) {
            elev.Afisare();
        }
    }

    public float medie_pe_clasa(){
        float medie = 0f;
        for (Elev elev : elevi) {
            medie += elev.medie_elev();
        }
        return medie/9;
    }

    public void detalii_clasa() {
        int total_absente = 0;
        for (Elev elev : elevi) total_absente += elev.absente_elev();
        System.out.println("Pentru clasa"+denumire+" , avem diriginte pe "+diriginte.getNume()+" "+diriginte.getPrenume()+",, cu un numar de "+elevi.length+" elevi, media pe clasa:"+medie_pe_clasa()+" , si un numar total de absente de "+total_absente);

    }

    public float cea_mai_mare_medie_clasa(){
        float maxim = 0f;
        for (Elev elev : elevi) {
            if (elev.medie_elev() > maxim) {
                maxim = elev.medie_elev();
            }
        }
        return maxim;
    }
    @Override
    public void cei_mai_buni_elevi(int n) {
        Arrays.sort(elevi, new Comparator<Elev>() {
            @Override
            public int compare(Elev o1, Elev o2) {
                if(o1.medie_elev() > o2.medie_elev())
                    return -1;
                if(o1.medie_elev() < o2.medie_elev())
                return 1;
                    return 0;
            }
        });
        for( int i=0;i<n;++i)
        {
            System.out.println((i+1)+". "+elevi[i].getNume()+" "+elevi[i].getPrenume()+", media: "+elevi[i].medie_elev() );
        }
    }
}
