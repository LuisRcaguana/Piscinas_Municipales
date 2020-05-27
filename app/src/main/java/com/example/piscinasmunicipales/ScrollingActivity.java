package com.example.piscinasmunicipales;

import android.os.Bundle;

import com.example.piscinasmunicipales.Datos.Contenido;
import com.example.piscinasmunicipales.Datos.Contenido2;
import com.example.piscinasmunicipales.Datos.Graph;
import com.example.piscinasmunicipales.RetroFitUtils.ApiPiscinasService;
import com.example.piscinasmunicipales.RetroFitUtils.RetrofitPiscinas;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.widget.TextView;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {


    TextView tvdatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        tvdatos = findViewById(R.id.txDatos);

        String idP = getIntent().getStringExtra(ConsultaActivity.CLAVE_IDPISCINA);

        Retrofit r = RetrofitPiscinas.getClient(ApiPiscinasService.Base_URL);
        ApiPiscinasService api = r.create(ApiPiscinasService.class);
        Call<Contenido2> call = api.obtenerDatosPiscinas(idP);
        call.enqueue(new Callback<Contenido2>() {
            @Override
            public void onResponse(Call<Contenido2> call, Response<Contenido2> response) {
                if(response.isSuccessful()){
                    Contenido2 contenido = response.body();

                    //osea cambio el grpah



                }

            }

            @Override
            public void onFailure(Call<Contenido2> call, Throwable t) {

            }
        });


    }
}
