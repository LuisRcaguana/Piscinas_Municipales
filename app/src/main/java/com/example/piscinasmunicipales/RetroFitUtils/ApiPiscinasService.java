package com.example.piscinasmunicipales.RetroFitUtils;

import com.example.piscinasmunicipales.Datos.Contenido;
import com.example.piscinasmunicipales.Datos.Contenido2;
import com.example.piscinasmunicipales.Datos.Graph;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiPiscinasService {

    public static String Base_URL = "https://datos.madrid.es/";

    @GET("egob/catalogo/210227-0-piscinas-publicas.json")
    Call<Contenido>obtenerPiscinaPorDisc(@Query("distrito_nombre")String distrito);

    @GET("egob/catalogo/tipo/entidadesyorganismos/{id_piscina}")
    Call<Contenido2> obtenerDatosPiscinas(@Path("id_piscina") String idpis);


}
