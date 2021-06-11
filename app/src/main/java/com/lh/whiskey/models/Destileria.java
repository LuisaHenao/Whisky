package com.lh.whiskey.models;

import com.google.gson.annotations.SerializedName;

public class Destileria {

    @SerializedName("slug")
    private String SlugDestileria;

    @SerializedName("name")
    private String NameDestileria;

    @SerializedName("country")
    private String Continente;

    @SerializedName("dt")
    private String Fecha;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getLoteDest() {
        return LoteDest;
    }

    public void setLoteDest(String loteDest) {
        LoteDest = loteDest;
    }

    @SerializedName("lots_count")
    private String LoteDest;

    public String getSlugDestileria() {
        return SlugDestileria;
    }

    public void setSlugDestileria(String slugDestileria) {
        SlugDestileria = slugDestileria;
    }

    public String getNameDestileria() {
        return NameDestileria;
    }

    public void setNameDestileria(String nameDestileria) {
        NameDestileria = nameDestileria;
    }

    public String getContinente() {
        return Continente;
    }

    public void setContinente(String continente) {
        Continente = continente;
    }




}
