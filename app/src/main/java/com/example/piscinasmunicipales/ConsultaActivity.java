package com.example.piscinasmunicipales;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.piscinasmunicipales.Datos.Contenido;
import com.example.piscinasmunicipales.Datos.Graph;
import com.example.piscinasmunicipales.RetroFitUtils.ApiPiscinasService;
import com.example.piscinasmunicipales.RetroFitUtils.RetrofitPiscinas;
import com.example.piscinasmunicipales.Rv.PiscinasAdapter;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ConsultaActivity extends AppCompatActivity {

    public static final String CLAVE_IDPISCINA = "IDPISC";
    RecyclerView rv;
    PiscinasAdapter psc;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        String provincia = getIntent().getStringExtra(MainActivity.CLAVE_PROVINCIA);
        Retrofit r = RetrofitPiscinas.getClient(ApiPiscinasService.Base_URL);
        ApiPiscinasService ars = r.create(ApiPiscinasService.class);
        Call<Contenido> call = ars.obtenerPiscinaPorDisc(provincia);
        call.enqueue(new Callback<Contenido>() {
            @Override
            public void onResponse(Call<Contenido> call, Response<Contenido> response) {
                if(response.isSuccessful()){
                    Contenido contenido = response.body();
                    ArrayList<Graph> lista = (ArrayList<Graph>) contenido.getGraph();
                   // ArrayList<Graph> lista = (ArrayList<Graph>) contenido.getGraph();
                    cargarRv(lista);
                }
                Log.e("onResponse", "error;" + response.code());

            }

            @Override
            public void onFailure(Call<Contenido> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "error: "+ t.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.e("onFailure", "error: " + t.getMessage());

            }
        });

    }

    private void cargarRv(final ArrayList<Graph> lista) {
        rv = findViewById(R.id.cve);

        psc = new PiscinasAdapter(lista);
        psc.setListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Intent i = new Intent(ConsultaActivity.this,
                        ScrollingActivity.class);

                //calculado
               String id = lista.get(rv.getChildAdapterPosition(v)).getId();
               String json = id.substring(id.lastIndexOf("/") + 1);
                i.putExtra(CLAVE_IDPISCINA, json);
                startActivity(i);

            }
        });
        llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        rv.setAdapter(psc);

    }


}
