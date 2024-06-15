package com.example.apphostal.Entity;


import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class Extras extends Fragment implements Serializable {
    private int registro;
    private int agua;
    private int papleh;
    private int cafen;
    private int cafec;
    private int leche;
    private int tem;
    private int tenegro;
    private int galletas;
    private int azucar;
    private int sacarinas;
    private int maquillaje;
    private int dulceextra;

    // Constructor completo

    public Extras(int registro, int agua, int papleh, int cafen, int cafec, int leche, int tem, int tenegro, int galletas, int azucar, int sacarinas, int maquillaje, int dulceextra) {
        this.registro = registro;
        this.agua = agua;
        this.papleh = papleh;
        this.cafen = cafen;
        this.cafec = cafec;
        this.leche = leche;
        this.tem = tem;
        this.tenegro = tenegro;
        this.galletas = galletas;
        this.azucar = azucar;
        this.sacarinas = sacarinas;
        this.maquillaje = maquillaje;
        this.dulceextra = dulceextra;
    }

    // Getters y Setters
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getPapleh() {
        return papleh;
    }

    public void setPapleh(int papleh) {
        this.papleh = papleh;
    }

    public int getCafen() {
        return cafen;
    }

    public void setCafen(int cafen) {
        this.cafen = cafen;
    }

    public int getCafec() {
        return cafec;
    }

    public void setCafec(int cafec) {
        this.cafec = cafec;
    }

    public int getLeche() {
        return leche;
    }

    public void setLeche(int leche) {
        this.leche = leche;
    }

    public int getTem() {
        return tem;
    }

    public void setTem(int tem) {
        this.tem = tem;
    }

    public int getTenegro() {
        return tenegro;
    }

    public void setTenegro(int tenegro) {
        this.tenegro = tenegro;
    }

    public int getGalletas() {
        return galletas;
    }

    public void setGalletas(int galletas) {
        this.galletas = galletas;
    }

    public int getAzucar() {
        return azucar;
    }

    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public int getSacarinas() {
        return sacarinas;
    }

    public void setSacarinas(int sacarinas) {
        this.sacarinas = sacarinas;
    }

    public int getMaquillaje() {
        return maquillaje;
    }

    public void setMaquillaje(int maquillaje) {
        this.maquillaje = maquillaje;
    }

    public int getDulceextra() {
        return dulceextra;
    }

    public void setDulceextra(int dulceextra)
    {
        this.dulceextra = dulceextra;
    }

    @Override
    public String toString() {
        return "Extras{" +
                "registro=" + registro +
                ", agua=" + agua +
                ", papleh=" + papleh +
                ", cafen=" + cafen +
                ", cafec=" + cafec +
                ", leche=" + leche +
                ", tem=" + tem +
                ", tenegro=" + tenegro +
                ", galletas=" + galletas +
                ", azucar=" + azucar +
                ", sacarinas=" + sacarinas +
                ", maquillaje=" + maquillaje +
                ", dulceextra=" + dulceextra +
                    '}';
    }
}
