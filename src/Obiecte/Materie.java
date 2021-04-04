package Obiecte;

public class Materie {
    private final String nume_materie;
    private final Profesor profesor;

    public Materie(String nume_materie, Profesor profesor) {
        this.nume_materie = nume_materie;

        this.profesor = profesor;
    }

    public String getNume_materie() {
        return nume_materie;
    }


    public void afisare() {
        System.out.print(nume_materie+", "+profesor.getNume()+", "+profesor.getPrenume());
    }
}
