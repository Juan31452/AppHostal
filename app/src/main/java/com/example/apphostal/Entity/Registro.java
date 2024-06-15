package com.example.apphostal.Entity;

import java.io.Serializable;

public class Registro implements Serializable {
    private int id;
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
    private String rellenoN;

    // Constructor sin ID
    public Registro(String fecha, String habitacion, String estado, String bajera, String encimera, String fundaA, String protectorA, String nordica, String colchav, String toallaD, String toallaL, String alfombrin, String paid, String protectorC, String rellenoN) {
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
        this.rellenoN = rellenoN;
    }

    // Constructor con ID
    public Registro(int id, String fecha, String habitacion, String estado, String bajera, String encimera, String fundaA, String protectorA, String nordica, String colchav, String toallaD, String toallaL, String alfombrin, String paid, String protectorC, String rellenoN)  {
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
        this.rellenoN = rellenoN;
    }

    public Registro() {

    }



    // Getters y Setters

    public int getId(){
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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setBajera(String bajera) {
        this.bajera = bajera;
    }

    public void setEncimera(String encimera) {
        this.encimera = encimera;
    }

    public void setFundaA(String fundaA) {
        this.fundaA = fundaA;
    }

    public void setProtectorA(String protectorA) {
        this.protectorA = protectorA;
    }

    public void setNordica(String nordica) {
        this.nordica = nordica;
    }

    public void setColchav(String colchav) {
        this.colchav = colchav;
    }

    public void setToallaD(String toallaD) {
        this.toallaD = toallaD;
    }

    public void setToallaL(String toallaL) {
        this.toallaL = toallaL;
    }

    public void setAlfombrin(String alfombrin) {
        this.alfombrin = alfombrin;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public void setProtectorC(String protectorC) {
        this.protectorC = protectorC;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRellenoN() {
        return rellenoN;
    }
    public void setRellenoN(String rellenoN) {
        this.rellenoN = rellenoN;
    }
    @Override
    public String toString() {
        return
                "Fecha=" + fecha +
                ", Habitacion=" + habitacion +
                ", Estado=" + estado ;
    }
}
