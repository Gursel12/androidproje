package com.example.gursel.newproject.Models;

public class ilacpojo {

    private String tarih;
    private String ilacadi;

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getIlacadi() {
        return ilacadi;
    }

    public void setIlacadi(String ilacadi) {
        this.ilacadi = ilacadi;
    }

    @Override
    public String toString() {
        return "ilacpojo{" +
                "tarih='" + tarih + '\'' +
                ", ilacadi='" + ilacadi + '\'' +
                '}';
    }
}
