package com.example.piscinasmunicipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etProv;

    public static final String CLAVE_PROVINCIA = "PROVINCIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProv = findViewById(R.id.Datos);



    }

    public void Busqueda(View view) {
        String provincias = etProv.getText().toString().trim();


        if (provincias.isEmpty()){
            Toast.makeText(this,(R.string.no_datos),
                    Toast.LENGTH_LONG).show();

        }else if (provincias.equals("ARGANZUELA")||provincias.equals("BARAJAS")||provincias.equals("CARABANCHEL")
                ||provincias.equals("CENTRO")||provincias.equals("CHAMARTIN")||provincias.equals("CHAMBERI")||provincias.equals("CIUDAD LINEAL")
                ||provincias.equals("FUENCARRAL-EL PARDO")||provincias.equals("HORTALEZA")||provincias.equals("LATINA")||provincias.equals("MONCLOA-ARAVACA")||provincias.equals("MORATALAZ")
                ||provincias.equals("PUENTE DE VALLECAS")||provincias.equals("RETIRO")||provincias.equals("SALAMANCA")||provincias.equals("SAN BLAS-CANILLEJAS")
                ||provincias.equals("TETUAN")||provincias.equals("USERA")||provincias.equals("VICALVARO")||provincias.equals("VILLA DE VALLECAS")
                ||provincias.equals("VILLAVERDE")){
            Intent i = new Intent(this, ConsultaActivity.class);
            String provi = etProv.getText().toString();
            i.putExtra(CLAVE_PROVINCIA, provi);
            startActivity(i);
        }else{
            Toast.makeText(this,(R.string.datosdesco),
                    Toast.LENGTH_LONG).show();

        }
    }

    }

