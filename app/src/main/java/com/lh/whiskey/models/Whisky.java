package com.lh.whiskey.models;

import com.google.gson.annotations.SerializedName;

public class Whisky {

    @SerializedName("slug")
    private String SlugWhisky;

    @SerializedName("name")
    private String NameWhisky;

    @SerializedName("base_currency")
    private String BaseWhisky;

    @SerializedName("url")
    private String Url;

    @SerializedName("dt")
    private String Dt;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String dt) {
        Dt = dt;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    @SerializedName("auction_lots_count")
    private String Lote;

    public String getSlugWhisky() {
        return SlugWhisky;
    }

    public void setSlugWhisky(String slugWhisky) {
        SlugWhisky = slugWhisky;
    }

    public String getNameWhisky() {
        return NameWhisky;
    }

    public void setNameWhisky(String nameWhisky) {
        NameWhisky = nameWhisky;
    }

    public String getBaseWhisky() {
        return BaseWhisky;
    }

    public void setBaseWhisky(String baseWhisky) {
        BaseWhisky = baseWhisky;
    }
}
