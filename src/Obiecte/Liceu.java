package Obiecte;

import Servicii.Afisare;

import java.util.Arrays;
import java.util.Comparator;

public class Liceu implements Afisare {
    private final String Denumire_liceu;
    private final Director director;
    private final Clasa[] clase;

    public Liceu(String denumire_liceu, Director director, Clasa[] clase) {
        Denumire_liceu = denumire_liceu;
        this.director = director;
        this.clase = clase;
    }

    public String getDenumire_liceu() {
        return Denumire_liceu;
    }

    @Override
    public void Afisare() {
        System.out.println(Denumire_liceu+" ,"+director.getNume()+", "+ director.getPrenume());
        for (Clasa clasa : clase) {
            clasa.Afisare();
        }
    }

    public float media_pe_liceu() {
        float medie = 0f;
        for (Clasa clasa : clase) {
            medie += clasa.medie_pe_clasa();
        }
        return medie/2;
    }

    public float cea_mai_mare_medie_liceu(){
        float maxim = 0f;
        for (Clasa clasa : clase) {
            if (clasa.medie_pe_clasa() > maxim)
                maxim = clasa.cea_mai_mare_medie_clasa();
        }
        return maxim;
    }

    @Override
    public void cei_mai_buni_elevi(int n) {
        Elev[] elevi = new Elev[20];
        int numberofelevi = 0;
        for (Clasa clasa : clase)
            for (int j = 0; j < clasa.getElevi().length; ++j) {

                elevi[numberofelevi] = clasa.getElevi()[j];
                ++numberofelevi;
            }

        Arrays.sort(elevi, new Comparator<Elev>() {
            @Override
            public int compare(Elev o1, Elev o2)  {
                if(o1.medie_elev() > o2.medie_elev())
                    return -1;
                if(o1.medie_elev() < o2.medie_elev())
                    return 1;
                return 0;
            }
        });
           for(int i=0;i< n;++i)
               System.out.println( (i+1)+" " + elevi[i].getNume()+" "+elevi[i].getPrenume()+" media: "+elevi[i].medie_elev());
    }
    public Elev cel_mai_ciulangiu(Liceu l){
        int maxim = 0;
        Elev elev = new Elev();
        for(int i=0;i< l.clase.length;++i)
            for(int j=0; j<l.clase[i].getElevi().length;++j)
            {
                if(l.clase[i].getElevi()[j].absente_elev() > maxim)
                {
                    maxim = l.clase[i].getElevi()[j].absente_elev();
                    elev = l.clase[i].getElevi()[j];
                }

            }
        return elev;
    }

    public void corigentii(Liceu l){
        System.out.println("Elevi corigentii sunt: ");
        for(int i=0;i< l.clase.length;++i)
            for(int j=0; j<l.clase[i].getElevi().length;++j)
            { boolean da = false;
                for(int k=0; k<l.clase[i].getElevi()[j].getMedii().length; ++k) {

                    if (l.clase[i].getElevi()[j].getMedii()[k] <= 4) {
                        da = true;
                                           }}
                if(da)
                System.out.println(l.clase[i].getElevi()[j].getNume() + " " + l.clase[i].getElevi()[j].getPrenume());
            }
    }

    public void elevi_olimpici(){
        System.out.println("Elevii olipici din liceul "+Denumire_liceu+", sunt :");
        for(int i=0;i< clase.length;++i)
            for(int j=0; j<clase[i].getElevi().length;++j)
                if(clase[i].getElevi()[j].getConcursuri() != null)
                clase[i].getElevi()[j].olimpic();
    }

}
