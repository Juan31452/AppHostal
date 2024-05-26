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
    private String toallaD;
    private String toallaL;
    private String alfombrin;
    private String paid;
    private String protectorC;

    // Constructor
    public Registro(String fecha, String habitacion, String estado, String bajera, String encimera,
                    String fundaA, String protectorA, String nordica, String toallaD, String toallaL,
                    String alfombrin, String paid, String protectorC) {
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.estado = estado;
        this.bajera = bajera;
        this.encimera = encimera;
        this.fundaA = fundaA;
        this.protectorA = protectorA;
        this.nordica = nordica;
        this.toallaD = toallaD;
        this.toallaL = toallaL;
        this.alfombrin = alfombrin;
        this.paid = paid;
        this.protectorC = protectorC;
    }

    // Constructor vacío
    public Registro() {
    }

    // Getters and Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBajera() {
        return bajera;
    }

    public void setBajera(String bajera) {
        this.bajera = bajera;
    }

    public String getEncimera() {
        return encimera;
    }

    public void setEncimera(String encimera) {
        this.encimera = encimera;
    }

    public String getFundaAlmohada() {
        return fundaA;
    }

    public void setFundaAlmohada(String fundaA) {
        this.fundaA = fundaA;
    }

    public String getProtectorAlmohada() {
        return protectorA;
    }

    public void setProtectorAlmohada(String protectorA) {
        this.protectorA = protectorA;
    }

    public String getNordica() {
        return nordica;
    }

    public void setNordica(String nordica) {
        this.nordica = nordica;
    }

    public String getToallaDucha() {
        return toallaD;
    }

    public void setToallaDucha(String toallaD) {
        this.toallaD = toallaD;
    }

    public String getToallaLavabo() {
        return toallaL;
    }

    public void setToallaLavabo(String toallaL) {
        this.toallaL = toallaL;
    }

    public String getAlfombrin() {
        return alfombrin;
    }

    public void setAlfombrin(String alfombrin) {
        this.alfombrin = alfombrin;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getProtectorColchon() {
        return protectorC;
    }

    public void setProtectorColchon(String protectorC) {
        this.protectorC = protectorC;
    }
}
