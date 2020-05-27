package com.example.piscinasmunicipales.Datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Graph  {

  /* lll
   @SerializedName("@id")
    @Expose
    private String aid;
    @SerializedName("@type")
    @Expose
    private String type;*/

    @SerializedName("@id")
    @Expose
    private String aid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("location")
    @Expose
    private Location location;
    /*@SerializedName("organization")
    @Expose
    private Organization organization;*/


    public String getId() {
        return aid;
    }

    public void setId(String id) {
        this.aid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}