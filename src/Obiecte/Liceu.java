package Obiecte;

import Servicii.Afisare;

import java.util.Arrays;

public class Liceu implements Afisare {
    private final String Denumire_liceu;
    private final Director director;
    private final Clasa[] clase;

    public Liceu(String denumire_liceu, Director director, Clasa[] clase) {
        Denumire_liceu = denumire_liceu;
        this.director = director;
        this.clase = clase;
    }

    public Director getDirector() {
        return director;
    }

    public Clasa[] getClase() {
        return clase;
    }

    public String getDenumire_liceu() {
        return Denumire_liceu;
    }

    @Override
    public void afisare() {
        System.out.println(Denumire_liceu+" ,"+director.getNume()+", "+ director.getPrenume());
        for (Clasa clasa : clase) {
            clasa.afisare();
        }
    }

    public float mediaPeLiceu() {
        float medie = 0f;
        for (Clasa clasa : clase) {
            medie += clasa.mediePeClasa();
        }
        return medie/2;
    }

    public float ceaMaiMareMedieLiceu(){
        float maxim = 0f;
        for (Clasa clasa : clase) {
            if (clasa.mediePeClasa() > maxim)
                maxim = clasa.ceaMaiMareMedieClasa();
        }
        return maxim;
    }

    @Override
    public void ceiMaiBuniElevi(int n) {
        Elev[] elevi = new Elev[20];
        int numberofelevi = 0;
        for (Clasa clasa : clase)
            for (int j = 0; j < clasa.getElevi().length; ++j) {

                elevi[numberofelevi] = clasa.getElevi()[j];
                ++numberofelevi;
            }

        Arrays.sort(elevi, (o1, o2) -> Float.compare(o2.medieElev(), o1.medieElev()));
           for(int i=0;i< n;++i)
               System.out.println( (i+1)+" " + elevi[i].getNume()+" "+elevi[i].getPrenume()+" media: "+elevi[i].medieElev());
    }
    public Elev celMaiCiulangiu(Liceu l){
        int maxim = 0;
        Elev elev = new Elev();
        for(int i=0;i< l.clase.length;++i)
            for(int j=0; j<l.clase[i].getElevi().length;++j)
            {
                if(l.clase[i].getElevi()[j].absenteElev() > maxim)
                {
                    maxim = l.clase[i].getElevi()[j].absenteElev();
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

    public void eleviOlimpici(){
        System.out.println("Elevii olipici din liceul "+Denumire_liceu+", sunt :");
        for (Clasa clasa : clase)
            for (int j = 0; j < clasa.getElevi().length; ++j)
                if (clasa.getElevi()[j].getConcursuri() != null)
                    clasa.getElevi()[j].olimpic();
    }

}
