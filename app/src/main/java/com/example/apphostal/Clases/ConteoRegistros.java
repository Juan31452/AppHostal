package com.example.apphostal.Clases;

public class ConteoRegistros {
    private int countBajeras;
    private int countEncimeras;
    private int countFundaAlmohada;
    private int countProtectorAlmohada;
    private int countNordica;
    private int countColchaVerano;
    private int countToallaDucha;
    private int countToallaLavabo;
    private int countAlfombrin;
    private int countPaid;
    private int countProtectorColchon;
    private int countRellenoNordico;

    public ConteoRegistros(int countBajeras, int countEncimeras, int countFundaAlmohada, int countProtectorAlmohada, int countNordica,
                           int countColchaVerano, int countToallaDucha, int countToallaLavabo, int countAlfombrin,
                           int countPaid, int countProtectorColchon, int countRellenoNordico)
    {
        this.countBajeras = countBajeras;
        this.countEncimeras = countEncimeras;
        this.countFundaAlmohada = countFundaAlmohada;
        this.countProtectorAlmohada = countProtectorAlmohada;
        this.countNordica = countNordica;
        this.countColchaVerano = countColchaVerano;
        this.countToallaDucha = countToallaDucha;
        this.countToallaLavabo = countToallaLavabo;
        this.countAlfombrin = countAlfombrin;
        this.countPaid = countPaid;
        this.countProtectorColchon = countProtectorColchon;
        this.countRellenoNordico = countRellenoNordico;

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

    public int getCountRellenoNordico() {
        return countRellenoNordico;
    }

    public void setCountRellenoNordico(int countRellenoNordico) {
        this.countRellenoNordico = countRellenoNordico;
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
                ", RellenoNordico=" + countRellenoNordico +
                '}';
    }
}
