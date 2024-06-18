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

    // Constructor para inserción sin id
    public Lavanderia(String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav, int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN) {
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

    public Lavanderia(int id, String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav, int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN) {
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
        this.paid = paid;
        this.protectorC = protectorC;
        this.rellenoN = rellenoN;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public int getBajera() {
        return bajera;
    }

    public int getEncimera() {
        return encimera;
    }

    public int getFundaA() {
        return fundaA;
    }

    public int getProtectorA() {
        return protectorA;
    }

    public int getNordica() {
        return nordica;
    }

    public int getColchav() {
        return colchav;
    }

    public int getToallaD() {
        return toallaD;
    }

    public int getToallaL() {
        return toallaL;
    }

    public int getAlfombrin() {
        return alfombrin;
    }

    public int getPaid() {
        return paid;
    }

    public int getProtectorC() {
        return protectorC;
    }

    public int getRellenoN() {
        return rellenoN;
    }


    @Override
    public String toString() {
        return "Lavanderia{id=" + id +
                ", fecha='" + fecha + '\'' +
                ", bajera=" + bajera +
                ", encimera=" + encimera +
                ", fundaA=" + fundaA +
                ", protectorA=" + protectorA +
                ", nordica=" + nordica +
                // Incluir otros campos aquí según sea necesario
                '}';
    }
}

