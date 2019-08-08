package com.example.gursel.newproject.RestApi;







import com.example.gursel.newproject.Models.Embrioresimpojo;
import com.example.gursel.newproject.Models.Labsatirpojo;
import com.example.gursel.newproject.Models.Labsonucpojo;
import com.example.gursel.newproject.Models.Loginpojo;
import com.example.gursel.newproject.Models.Mesajcevappojo;
import com.example.gursel.newproject.Models.Mesajpojo;
import com.example.gursel.newproject.Models.Spinnerdoktorpojo;
import com.example.gursel.newproject.Models.Tedavipojo;
import com.example.gursel.newproject.Models.ilacpojo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

    @FormUrlEncoded
    @POST("Tlogin.php")
    Call<Loginpojo> control(@Field("tckimlik") String tckimlik ,@Field("sifre") String sifre);


    @GET("Tlabsonuc.php")
    Call<List<Labsonucpojo>> labsonuc(@Query("uyeid") String uye_id);

    @GET("Tsatir.php")
    Call<List<Labsatirpojo>> labsatir(@Query("guid") String uye_id);


    @GET("Tembriyoresim.php")
    Call<List<Embrioresimpojo>> Embriyo(@Query("pno") String uye_id);

    @GET("Ttedavi.php")
    Call<List<Tedavipojo>> tedavi(@Query("pno") String uye_id);

    @GET("Tilaclar.php")
    Call<List<ilacpojo>> ilac(@Query("pno") String uye_id);


    @GET("Tdoktorspinner.php")
    Call<List<Spinnerdoktorpojo>> spinnerdoktor();

    @FormUrlEncoded
    @POST("Tmesaj.php")
    Call<Mesajpojo> controlmesaj(@Field("mesaj") String mesaj, @Field("pno") String pno, @Field("doktor") String doktor, @Field("tarih") String tarih,@Field("adi")String ad,@Field("soyadi") String soyad);

    @GET("Tmesajcevap.php")
    Call<List<Mesajcevappojo>> cevap(@Query("uyeid") String uye_id);



}
