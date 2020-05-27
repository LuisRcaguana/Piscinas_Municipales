package com.example.piscinasmunicipales.Datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contenido2 {

    @SerializedName("@context")
    @Expose
    private Context2 context;
    @SerializedName("@graph")
    @Expose
    private List<Graph2> graph = null;

    public Context2 getContext() {
        return context;
    }

    public void setContext(Context2 context) {
        this.context = context;
    }

    public List<Graph2> getGraph() {
        return graph;
    }

    public void setGraph(List<Graph2> graph) {
        this.graph = graph;
    }
}