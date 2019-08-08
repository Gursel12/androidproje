package com.example.gursel.newproject.Models;

public class Labsatirpojo {

    private String atetkik;

    private String bulgu;
    private String guid1;
    private String lmin;
    private String lmax;

    public String getLmin() {
        return lmin;
    }

    public void setLmin(String lmin) {
        this.lmin = lmin;
    }

    public String getLmax() {
        return lmax;
    }

    public void setLmax(String lmax) {
        this.lmax = lmax;
    }

    public String getGuid1() {
        return guid1;
    }

    public void setGuid(String guid) {
        this.guid1 = guid;
    }

    public String getAtetkik() {
        return atetkik;
    }

    public void setAtetkik(String atetkik) {
        this.atetkik = atetkik;
    }

    public String getBulgu() {
        return bulgu;
    }

    public void setBulgu(String bulgu) {
        this.bulgu = bulgu;
    }

    @Override
    public String toString() {
        return "Labsatirpojo{" +
                "atetkik='" + atetkik + '\'' +
                ", bulgu='" + bulgu + '\'' +
                ", guid1='" + guid1 + '\'' +
                ", lmin='" + lmin + '\'' +
                ", lmax='" + lmax + '\'' +
                '}';
    }
}
