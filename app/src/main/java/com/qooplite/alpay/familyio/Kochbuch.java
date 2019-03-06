package com.qooplite.alpay.familyio;

public class Kochbuch {

    private String id;
    private String name;
    private String schwierigkeitsgrad;
    private String typ;


    public Kochbuch(String id, String name, String schwierigkeitsgrad, String typ){

        this.id = id;
        this.name = name;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.typ = typ;

    }

    public Kochbuch(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public void setSchwierigkeitsgrad(String schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
