package com.qooplite.alpay.familyio;

public class Aktivierungscode {

    private String aktivierungscode;
    private String familie;


    public Aktivierungscode(String aktivierungscode, String familie) {

        this.aktivierungscode = aktivierungscode;
        this.familie = familie;

    }

    public Aktivierungscode() {}


    public String getAktivierungscode() {
        return aktivierungscode;
    }

    public void setAktivierungscode(String aktivierungscode) {
        this.aktivierungscode = aktivierungscode;
    }

    public String getFamilie() {
        return familie;
    }

    public void setFamilie(String familie) {
        this.familie = familie;
    }
}
