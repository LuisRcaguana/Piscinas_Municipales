package com.example.piscinasmunicipales;

import android.os.Bundle;

import com.example.piscinasmunicipales.Datos.Contenido2;
import com.example.piscinasmunicipales.Datos.Graph2;
import com.example.piscinasmunicipales.RetroFitUtils.ApiPiscinasService;
import com.example.piscinasmunicipales.RetroFitUtils.RetrofitPiscinas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ScrollingActivity extends AppCompatActivity {
    TextView tvNomre;
    TextView tvLocalidad;
    TextView tvCodigoP;
    TextView tvServi;
    TextView tvAcc;
    TextView tvCalen;
    TextView tvOrgN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvNomre = findViewById(R.id.tvNombreD);
        tvLocalidad = findViewById(R.id.tvLocalidadD);
        tvCodigoP = findViewById(R.id.tvCodigoD);
        tvServi = findViewById(R.id.tvServiD);
        tvAcc = findViewById(R.id.tvAcccesiD);
        tvCalen = findViewById(R.id.tvCalenD);
        tvOrgN = findViewById(R.id.tvOrmen);



        String idp = getIntent().getStringExtra(ConsultaActivity.CLAVE_IDPISCINA);
        Retrofit r = RetrofitPiscinas.getClient(ApiPiscinasService.Base_URL);
        ApiPiscinasService api = r.create(ApiPiscinasService.class);
        Call<Contenido2> call = api.obtenerDatosPiscinas(idp);
        call.enqueue(new Callback<Contenido2>() {
            @Override
            public void onResponse(Call<Contenido2> call, Response<Contenido2> response) {
                if(response.isSuccessful()){
                    Contenido2 contenido2 = response.body();
                    ArrayList<Graph2> lista = (ArrayList<Graph2>)contenido2.getGraph();
                    Graph2 graph2 = lista.get(0);
                    tvNomre.setText(graph2.getTitle());
                    tvLocalidad.setText(graph2.getAddress().getLocality());
                    tvCodigoP.setText(graph2.getAddress().getPostalCode());
                    tvServi.setText(graph2.getOrganization().getServices());
                    tvAcc.setText(graph2.getOrganization().getAccesibility());
                    tvCalen.setText(graph2.getOrganization().getSchedule());
                    tvOrgN.setText(graph2.getOrganization().getOrganizationName());

                }
            }

            @Override
            public void onFailure(Call<Contenido2> call, Throwable t) {

            }
        });



    }
}
