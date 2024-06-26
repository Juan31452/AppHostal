package com.example.apphostal.Entity;

public class RopaSucia {

    private int id;
    private String fecha;
    private int bajeras;
    private int encimeras;
    private int fundaAlmohada;
    private int protectorAlmohada;
    private int nordica;
    private int colchaVerano;
    private int toallaDucha;
    private int toallaLavabo;
    private int alfombrin;
    private int paid;
    private int protectorColchon;
    private int rellenoNordico;
    private String entregado;

   public RopaSucia(int id, String fecha, int bajeras, int encimeras, int fundaAlmohada, int protectorAlmohada, int nordica, int colchaVerano,
                    int toallaDucha, int toallaLavabo, int alfombrin, int paid, int protectorColchon, int rellenoNordico, String entregado){
       this.id = id;
       this.fecha = fecha;
       this.bajeras = bajeras;
       this.encimeras = encimeras;
       this.fundaAlmohada = fundaAlmohada;
       this.protectorAlmohada = protectorAlmohada;
       this.nordica = nordica;
       this.colchaVerano = colchaVerano;
       this.toallaDucha = toallaDucha;
       this.toallaLavabo = toallaLavabo;
       this.alfombrin = alfombrin;
       this.paid = paid;
       this.protectorColchon = protectorColchon;
       this.rellenoNordico = rellenoNordico;
       this.entregado = "No";

   }

    public RopaSucia(String fecha, int bajeras, int encimeras, int fundaAlmohada, int protectorAlmohada, int nordica, int colchaVerano,
                     int toallaDucha, int toallaLavabo, int alfombrin, int paid, int protectorColchon, int rellenoNordico, String entregado){
        this.fecha = fecha;
        this.bajeras = bajeras;
        this.encimeras = encimeras;
        this.fundaAlmohada = fundaAlmohada;
        this.protectorAlmohada = protectorAlmohada;
        this.nordica = nordica;
        this.colchaVerano = colchaVerano;
        this.toallaDucha = toallaDucha;
        this.toallaLavabo = toallaLavabo;
        this.alfombrin = alfombrin;
        this.paid = paid;
        this.protectorColchon = protectorColchon;
        this.rellenoNordico = rellenoNordico;
        this.entregado = "No";

    }


    public RopaSucia() {
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getBajeras() {
        return bajeras;
    }

    public void setBajeras(int bajeras) {
        this.bajeras = bajeras;
    }

    public int getEncimeras() {
        return encimeras;
    }

    public void setEncimeras(int encimeras) {
        this.encimeras = encimeras;
    }

    public int getFundaAlmohada() {
        return fundaAlmohada;
    }

    public void setFundaAlmohada(int fundaAlmohada) {
        this.fundaAlmohada = fundaAlmohada;
    }

    public int getProtectorAlmohada() {
        return protectorAlmohada;
    }

    public void setProtectorAlmohada(int protectorAlmohada) {
        this.protectorAlmohada = protectorAlmohada;
    }

    public int getNordica() {
        return nordica;
    }

    public void setNordica(int nordica) {
        this.nordica = nordica;
    }

    public int getColchaVerano() {
        return colchaVerano;
    }

    public void setColchaVerano(int colchaVerano) {
        this.colchaVerano = colchaVerano;
    }

    public int getToallaDucha() {
        return toallaDucha;
    }

    public void setToallaDucha(int toallaDucha) {
        this.toallaDucha = toallaDucha;
    }

    public int getToallaLavabo() {
        return toallaLavabo;
    }

    public void setToallaLavabo(int toallaLavabo) {
        this.toallaLavabo = toallaLavabo;
    }

    public int getAlfombrin() {
        return alfombrin;
    }

    public void setAlfombrin(int alfombrin) {
        this.alfombrin = alfombrin;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getProtectorColchon() {
        return protectorColchon;
    }

    public void setProtectorColchon(int protectorColchon) {
        this.protectorColchon = protectorColchon;
    }

    public int getRellenoNordico() {
        return rellenoNordico;
    }

    public void setRellenoNordico(int rellenoNordico) {
        this.rellenoNordico = rellenoNordico;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }


@Override
public String toString() {
    return "RopaSucia{ID=" + id +
            ", fecha='" + fecha + '\'' +
            ",bajeras=" + bajeras +
            '}';
    }
}