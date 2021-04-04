package Obiecte;

public class Concursuri {
    private final String denumire;
    private final String etapa;
    private final String liceu_gazda;

    public Concursuri(String denumire, String etapa, String liceu_gazda) {
        this.denumire = denumire;
        this.etapa = etapa;
        this.liceu_gazda = liceu_gazda;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getEtapa() {
        return etapa;
    }

    public void afisare() {
        System.out.print(denumire+", "+etapa+", "+liceu_gazda);
    }
}
