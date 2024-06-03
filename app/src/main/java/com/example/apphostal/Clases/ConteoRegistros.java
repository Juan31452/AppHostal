package com.example.apphostal.Clases;

public class ConteoRegistros {
    private int countBajeras;
    private int countEncimeras;
    private int countFundaAlmohada;
    private int countProtectorAlmohada;
    private int countNordica;
    private int countColchaVerano;
    private int countToallaDucha;
    private int countAlfombrin;
    private int countPaid;    private int countToallaLavabo;

    private int countProtectorColchon;

    public static void add(ConteoRegistros registros) {
    }

    public int getCountBajeras() {
        return countBajeras;
    }

    public void setCountBajeras(int countBajeras) {
        this.countBajeras = countBajeras;
    }

    public int getCountEncimeras() {
        return countEncimeras;
    }

    public void setCountEncimeras(int countEncimeras) {
        this.countEncimeras = countEncimeras;
    }

    public int getCountFundaAlmohada() {
        return countFundaAlmohada;
    }

    public void setCountFundaAlmohada(int countFundaAlmohada) {
        this.countFundaAlmohada = countFundaAlmohada;
    }

    public int getCountProtectorAlmohada() {
        return countProtectorAlmohada;
    }

    public void setCountProtectorAlmohada(int countProtectorAlmohada) {
        this.countProtectorAlmohada = countProtectorAlmohada;
    }

    public int getCountNordica() {
        return countNordica;
    }

    public void setCountNordica(int countNordica) {
        this.countNordica = countNordica;
    }

    public int getCountColchaVerano() {
        return countColchaVerano;
    }

    public void setCountColchaVerano(int countColchaVerano) {
        this.countColchaVerano = countColchaVerano;
    }

    public int getCountToallaDucha() {
        return countToallaDucha;
    }

    public void setCountToallaDucha(int countToallaDucha) {
        this.countToallaDucha = countToallaDucha;
    }

    public int getCountToallaLavabo() {
        return countToallaLavabo;
    }

    public void setCountToallaLavabo(int countToallaLavabo) {
        this.countToallaLavabo = countToallaLavabo;
    }

    public int getCountAlfombrin() {
        return countAlfombrin;
    }

    public void setCountAlfombrin(int countAlfombrin) {
        this.countAlfombrin = countAlfombrin;
    }

    public int getCountPaid() {
        return countPaid;
    }

    public void setCountPaid(int countPaid) {
        this.countPaid = countPaid;
    }

    public int getCountProtectorColchon() {
        return countProtectorColchon;
    }

    public void setCountProtectorColchon(int countProtectorColchon) {
        this.countProtectorColchon = countProtectorColchon;
    }

    @Override
    public String toString() {
        return "Lista {" +
                "Bajeras=" + countBajeras +
                ", Encimeras=" + countEncimeras +
                ", FundaAlmohada=" + countFundaAlmohada +
                ", ProtectorAlmohada=" + countProtectorAlmohada +
                ", Nordica=" + countNordica +
                ", ColchaVerano=" + countColchaVerano +
                ", ToallaDucha=" + countToallaDucha +
                ", ToallaLavabo=" + countToallaLavabo +
                ", Alfombrin=" + countAlfombrin +
                ", Paid=" + countPaid +
                ", ProtectorColchon=" + countProtectorColchon +
                '}';
    }
}
