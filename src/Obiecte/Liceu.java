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
    public String afisare() {
        String result = Denumire_liceu+" ,"+director.getNume()+", "+ director.getPrenume()+"\n";
        for (Clasa clasa : clase) {
            result  = result + clasa.afisare() + "\n";
        }
        return result;
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
    public String ceiMaiBuniElevi(int n) {
        Elev[] elevi = new Elev[20];
        int numberofelevi = 0;
        for (Clasa clasa : clase)
            for (int j = 0; j < clasa.getElevi().length; ++j) {

                elevi[numberofelevi] = clasa.getElevi()[j];
                ++numberofelevi;
            }

        Arrays.sort(elevi, (o1, o2) -> Float.compare(o2.medieElev(), o1.medieElev()));
        String rezultat = ((1)+" " + elevi[0].getNume()+" "+elevi[0].getPrenume()+" media: "+elevi[0].medieElev() + "\n");
        for( int i=1;i<n;++i)
        {
            rezultat= rezultat + (i+1)+" " + elevi[i].getNume()+" "+elevi[i].getPrenume()+" media: "+elevi[i].medieElev()+"\n" ;
        }
        return rezultat;
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

    public String corigentii(Liceu l){
        String result = "Elevi corigentii sunt: "+ "\n" ;
        for(int i=0;i< l.clase.length;++i)
            for(int j=0; j<l.clase[i].getElevi().length;++j)
            { boolean da = false;
                for(int k=0; k<l.clase[i].getElevi()[j].getMedii().length; ++k) {

                    if (l.clase[i].getElevi()[j].getMedii()[k] <= 4) {
                        da = true;
                    }
                }
                if(da)
                result= result+l.clase[i].getElevi()[j].getNume() + " " + l.clase[i].getElevi()[j].getPrenume()+"\n";
            }
        return result;
    }

    public String eleviOlimpici(){
         String result = "Elevii olipici din liceul "+Denumire_liceu+", sunt :"+"\n";
        for (Clasa clasa : clase)
            for (int j = 0; j < clasa.getElevi().length; ++j)
                if (clasa.getElevi()[j].getConcursuri() != null)
                    result = result + clasa.getElevi()[j].olimpic()+"\n";
    return result;
    }

}
