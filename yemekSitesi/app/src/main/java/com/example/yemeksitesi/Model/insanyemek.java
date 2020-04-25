package com.example.yemeksitesi.Model;


import java.util.List;

public class insanyemek {

    private String gönderihaberlesme;
    private String gönderisim;
    private String gönderikisi;
    private String gönderiid;
    private String enlem;
    private String boylam;
    private String adres;


    public insanyemek() {
    }

    public insanyemek(String gönderisim, String gönderikisi, String gönderihaberlesme, String enlem, String boylam, String adres) {
        this.gönderihaberlesme = gönderihaberlesme;
        this.gönderisim = gönderisim;
        this.gönderikisi = gönderikisi;
        this.enlem = enlem;
        this.boylam = boylam;
        this.adres = adres;

    }

    public String getGönderihaberlesme() {
        return gönderihaberlesme;
    }

    public void setGönderihaberlesme(String gönderihaberlesme) {
        this.gönderihaberlesme = gönderihaberlesme;
    }

    public String getGönderisim() {
        return gönderisim;
    }

    public void setGönderisim(String gönderisim) {
        this.gönderisim = gönderisim;
    }

    public String getGönderikisi() {
        return gönderikisi;
    }

    public void setGönderikisi(String gönderikisi) {
        this.gönderikisi = gönderikisi;
    }
    public String getGönderiid() {
        return gönderiid;
    }

    public void setGönderiid(String gönderiid) {
        this.gönderiid = gönderiid;
    }

    public String getBoylam() {
        return boylam;
    }

    public void setBoylam(String boylam) {
        this.boylam = boylam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


    public String getEnlem() {
        return enlem;
    }

    public void setEnlem(String enlem) {
        this.enlem = enlem;
    }
}
