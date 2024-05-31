package com.example.apphostal.Clases;

import java.io.Serializable;

public class Registro implements Serializable {
    private String fecha;
    private String habitacion;
    private String estado;
    private String bajera;
    private String encimera;
    private String fundaA;
    private String protectorA;
    private String nordica;
    private String colchav;
    private String toallaD;
    private String toallaL;
    private String alfombrin;
    private String paid;
    private String protectorC;
    private int id;

    // Constructor sin ID
    public Registro(String fecha, String habitacion, String estado, String bajera, String encimera, String fundaA, String protectorA, String nordica, String colchav, String toallaD, String toallaL, String alfombrin, String paid, String protectorC) {
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.estado = estado;
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
    }

    // Constructor con ID
    public Registro(int id, String fecha, String habitacion, String estado, String bajera, String encimera, String fundaA, String protectorA, String nordica, String colchav, String toallaD, String toallaL, String alfombrin, String paid, String protectorC) {
        this.id = id;
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.estado = estado;
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
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public String getEstado() {
        return estado;
    }

    public String getBajera() {
        return bajera;
    }

    public String getEncimera() {
        return encimera;
    }

    public String getFundaA() {
        return fundaA;
    }

    public String getProtectorA() {
        return protectorA;
    }

    public String getNordica() {
        return nordica;
    }

    public String getColchav() {
        return colchav;
    }

    public String getToallaD() {
        return toallaD;
    }

    public String getToallaL() {
        return toallaL;
    }

    public String getAlfombrin() {
        return alfombrin;
    }

    public String getPaid() {
        return paid;
    }

    public String getProtectorC() {
        return protectorC;
    }
    @Override
    public String toString() {
        return
                "Fecha=" + fecha +
                ", Habitacion=" + habitacion +
                ", Estado=" + estado ;
    }
}
