package Obiecte;

import Servicii.Afisare;

import java.util.Arrays;

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
    public String afisare() {
        StringBuilder result = new StringBuilder(denumire + ", " + profil + ", " + diriginte.getNume() + "\n");
        for (Elev elev : elevi) {
            result.append(elev.Afisare());
        }
        return result.toString();
    }

    public float mediePeClasa(){
        float medie = 0f;
        for (Elev elev : elevi) {
            medie += elev.medieElev();
        }
        return medie/9;
    }

    public String detaliiClasa() {
        int total_absente = 0;
        for (Elev elev : elevi) total_absente += elev.absenteElev();
        return "Pentru clasa"+denumire+" , avem diriginte pe "+diriginte.getNume()+" "+diriginte.getPrenume()+",, cu un numar de "+elevi.length+" elevi, media pe clasa:"+ mediePeClasa()+" , si un numar total de absente de "+total_absente;
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
    public String ceiMaiBuniElevi(int n) {
        Arrays.sort(elevi, (o1, o2) -> Float.compare(o2.medieElev(), o1.medieElev()));
        StringBuilder rezultat = new StringBuilder((1) + ". " + elevi[0].getNume() + " " + elevi[0].getPrenume() + ", media: " + elevi[0].medieElev() + "\n");
        for( int i=1;i<n;++i)
        {
            rezultat.append(i + 1).append(". ").append(elevi[i].getNume()).append(" ").append(elevi[i].getPrenume()).append(", media: ").append(elevi[i].medieElev()).append("\n");
        }
        return rezultat.toString();
    }
}
