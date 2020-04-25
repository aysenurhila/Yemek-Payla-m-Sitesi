package com.example.yemeksitesi.Model;

public class Yemek {
    //boolean tur;
    private String haberlesmeTuru;
    private String isim;
    private String kisi;
    private String enlem;
    private String boylam;

    public Yemek(String haberlesmeTuru, String isim, String kisi, String enlem, String boylam) {
        super();
        this.haberlesmeTuru = haberlesmeTuru;
        this.isim = isim;
        this.kisi = kisi;
        this.enlem = enlem;
        this.boylam = boylam;
    }



    public String getHaberlesmeTuru() {
        return haberlesmeTuru;
    }

    public void setHaberlesmeTuru(String haberlesmeTuru) {
        this.haberlesmeTuru = haberlesmeTuru;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getKisi() {
        return kisi;
    }

    public void setKisi(String kisi) {
        this.kisi = kisi;
    }

    public String getEnlem() {
        return enlem;
    }

    public void setEnlem(String enlem) {
        this.enlem = enlem;
    }

    public String getBoylam() {
        return boylam;
    }

    public void setBoylam(String boylam) {
        this.boylam = boylam;
    }


}
