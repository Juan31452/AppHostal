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

    // Getters y setters
    // ...
}
