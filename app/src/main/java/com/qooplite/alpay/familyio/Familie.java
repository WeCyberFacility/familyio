package com.qooplite.alpay.familyio;

public class Familie {

    private String id;
    private String familienname;
    private String familienpasswort;
    private String anzahlkinder;
    private String wohnort;
    private String straße;
    private String aktivierungscode;
    private String Hintergrundbild;


    public Familie(String id, String familienname, String familienpasswort, String anzahlkinder, String wohnort, String straße, String aktivierungscode, String Hintegrundbild) {

        this.id = id;
        this.familienname = familienname;
        this.familienpasswort = familienpasswort;
        this.anzahlkinder = anzahlkinder;
        this.wohnort = wohnort;
        this.straße = straße;
        this.aktivierungscode = aktivierungscode;
        this.Hintergrundbild = Hintegrundbild;

    }

    public Familie() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilienname() {
        return familienname;
    }

    public void setFamilienname(String familienname) {
        this.familienname = familienname;
    }

    public String getFamilienpasswort() {
        return familienpasswort;
    }

    public void setFamilienpasswort(String familienpasswort) {
        this.familienpasswort = familienpasswort;
    }

    public String getAnzahlkinder() {
        return anzahlkinder;
    }

    public void setAnzahlkinder(String anzahlkinder) {
        this.anzahlkinder = anzahlkinder;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getAktivierungscode() {
        return aktivierungscode;
    }

    public void setAktivierungscode(String aktivierungscode) {
        this.aktivierungscode = aktivierungscode;
    }

    public String getHintergrundbild() {
        return Hintergrundbild;
    }

    public void setHintergrundbild(String hintergrundbild) {
        Hintergrundbild = hintergrundbild;
    }
}
