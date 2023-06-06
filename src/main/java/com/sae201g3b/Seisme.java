package com.sae201g3b;

public class Seisme {
    private Float Identifiant;
    private String Date;
    private String Heure;
    private String Nom;
    private String Région;
    private Float Choc;
    private Float X;
    private Float Y;
    private Float Latitude;
    private Float Longitude;
    private int Intensite;
    private String Qualite;

    public Seisme(Float identifiant, String date, String heure, String nom, String région, Float choc, Float x, Float y, Float latitude, Float longitude, int intensite, String qualite) {
        Identifiant = identifiant;
        Date = date;
        Heure = heure;
        Nom = nom;
        Région = région;
        Choc = choc;
        X = x;
        Y = y;
        Latitude = latitude;
        Longitude = longitude;
        Intensite = intensite;
        Qualite = qualite;
    }

    public Float getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(Float identifiant) {
        Identifiant = identifiant;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String heure) {
        Heure = heure;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getRégion() {
        return Région;
    }

    public void setRégion(String région) {
        Région = région;
    }

    public Float getChoc() {
        return Choc;
    }

    public void setChoc(Float choc) {
        Choc = choc;
    }

    public Float getX() {
        return X;
    }

    public void setX(Float x) {
        X = x;
    }

    public Float getY() {
        return Y;
    }

    public void setY(Float y) {
        Y = y;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    public int getIntensite() {
        return Intensite;
    }

    public void setIntensite(int intensite) {
        Intensite = intensite;
    }

    public String getQualite() {
        return Qualite;
    }

    public void setQualite(String qualite) {
        Qualite = qualite;
    }

    @Override
    public String toString() {
        return "Seisme{" +
                "Identifiant=" + Identifiant +
                ", Date='" + Date + '\'' +
                ", Heure='" + Heure + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Région='" + Région + '\'' +
                ", Choc=" + Choc +
                ", X=" + X +
                ", Y=" + Y +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Intensite=" + Intensite +
                ", Qualite='" + Qualite + '\'' +
                '}';
    }
}