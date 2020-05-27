package com.example.piscinasmunicipales.Rv;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.piscinasmunicipales.Datos.Contenido;
import com.example.piscinasmunicipales.Datos.Graph;
import com.example.piscinasmunicipales.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PiscinasAdapter extends RecyclerView.Adapter<PiscinasAdapter.PisHv>implements View.OnClickListener {

   private ArrayList<Graph>lista;

    View.OnClickListener listener;

    public PiscinasAdapter(ArrayList<Graph>lista){
       this.lista = lista;

    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }

    }
    public static  class PisHv extends RecyclerView.ViewHolder {
        TextView tvNombre, tvlongi, tvlatif;

        public PisHv( @NonNull View v) {

            super(v);
            tvNombre = v.findViewById(R.id.tvNombre);
            tvlongi = v.findViewById(R.id.tvlong);
            tvlatif = v.findViewById(R.id.tvlati);
        }

        public void  binPis(Graph contenido){
            tvNombre.setText(contenido.getTitle());
            tvlongi.setText(String.valueOf(contenido.getLocation().getLongitude()));
            tvlatif.setText(String.valueOf(contenido.getLocation().getLatitude()));

        }
    }

    @NonNull
    @Override
    public PisHv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_piscinas, parent, false);
        v.setOnClickListener(listener);
        return new PisHv(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PiscinasAdapter.PisHv holder, int position) {
        holder.binPis(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }
}
