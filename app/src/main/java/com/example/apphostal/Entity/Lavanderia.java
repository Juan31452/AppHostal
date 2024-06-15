package com.example.apphostal.Entity;

public class Lavanderia {
    private int id;
    private String fecha;
    private int bajera;
    private int encimera;
    private int fundaA;
    private int protectorA;
    private int nordica;
    private int colchav;
    private int toallaD;
    private int toallaL;
    private int alfombrin;
    private int paid;
    private int protectorC;
    private int rellenoN;


    public Lavanderia( String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav,
                      int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN) {
        //this.id = id;
        this.fecha = fecha;
        this.bajera = bajera;
        this.encimera = encimera;
        this.fundaA = fundaA;
        this.protectorA = protectorA;
        this.nordica = nordica;
        this.colchav = colchav;
        this.toallaD = toallaD;
        this.toallaL = toallaL;
        this.alfombrin = alfombrin;
        this.paid = paid;
        this.protectorC = protectorC;
        this.rellenoN = rellenoN;
    }

    public Lavanderia( int id,String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav,
                       int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN) {

    }


    public Lavanderia(int id, String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica,
                      int colchav, int toallaD, int toallaL, int alfombrin, int protectorC, int rellenoN) {
        this.id = id;
        this.fecha = fecha;
        this.bajera = bajera;
        this.encimera = encimera;
        this.fundaA = fundaA;
        this.protectorA = protectorA;
        this.nordica = nordica;
        this.colchav = colchav;
        this.toallaD = toallaD;
        this.toallaL = toallaL;
        this.alfombrin = alfombrin;
        this.protectorC = protectorC;
        this.rellenoN = rellenoN;
    }

    // Getters y Setters

    public int getId() {
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

    public int getBajera() {
        return bajera;
    }

    public void setBajera(int bajera) {
        this.bajera = bajera;
    }

    public int getEncimera() {
        return encimera;
    }

    public void setEncimera(int encimera) {
        this.encimera = encimera;
    }

    public int getFundaA() {
        return fundaA;
    }

    public void setFundaA(int fundaA) {
        this.fundaA = fundaA;
    }

    public int getProtectorA() {
        return protectorA;
    }

    public void setProtectorA(int protectorA) {
        this.protectorA = protectorA;
    }

    public int getNordica() {
        return nordica;
    }

    public void setNordica(int nordica) {
        this.nordica = nordica;
    }

    public int getColchav() {
        return colchav;
    }

    public void setColchav(int colchav) {
        this.colchav = colchav;
    }

    public int getToallaD() {
        return toallaD;
    }

    public void setToallaD(int toallaD) {
        this.toallaD = toallaD;
    }

    public int getToallaL() {
        return toallaL;
    }

    public void setToallaL(int toallaL) {
        this.toallaL = toallaL;
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

    public int getProtectorC() {
        return protectorC;
    }

    public void setProtectorC(int protectorC) {
        this.protectorC = protectorC;
    }

    public int getRellenoN() {
        return rellenoN;
    }

    public void setRellenoN(int rellenoN) {
        this.rellenoN = rellenoN;
    }
}

