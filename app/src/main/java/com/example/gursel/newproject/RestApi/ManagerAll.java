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

public class ManagerAll extends  BaseManager{

    private static  ManagerAll ourInstance=new ManagerAll();

    public static synchronized ManagerAll getOurInstance()
    {
        return ourInstance;
    }

    // LOGİN
    public Call<Loginpojo> login(String tckimlik, String sifre)
    {

        Call<Loginpojo> x=getRestApiClient().control(tckimlik, sifre);
        return x;
    }

   public Call<List<Labsonucpojo>> labsonuclarim(String uye_id)
    {
        Call<List<Labsonucpojo>> y=getRestApiClient().labsonuc(uye_id);
        return y;
    }

    public Call<List<Labsatirpojo>> labsatir(String uye_id)
    {
        Call<List<Labsatirpojo>> satir=getRestApiClient().labsatir(uye_id);
        return satir;
    }

    public Call<List<Embrioresimpojo>> embrioResimlerim(String uye_id)
    {
        Call<List<Embrioresimpojo>> y=getRestApiClient().Embriyo(uye_id);
        return y;
    }

    public Call<List<Tedavipojo>> tedavilerim(String uye_id)
    {
        Call<List<Tedavipojo>> z=getRestApiClient().tedavi(uye_id);
        return z;
    }

    public Call<List<ilacpojo>> ilaclarim(String uye_id)
    {
        Call<List<ilacpojo>> ilac=getRestApiClient().ilac(uye_id);
        return ilac;
    }


    public Call<List<Spinnerdoktorpojo>> spdoktorlarim()
    {
        Call<List<Spinnerdoktorpojo>> z=getRestApiClient().spinnerdoktor();
        return z;
    }

    public Call<Mesajpojo> eklemesaj(String mesaj, String pno, String doktor, String tarih,String ad,String soyad)
    {

        Call<Mesajpojo> x=getRestApiClient().controlmesaj(mesaj,pno,doktor,tarih,ad,soyad);
        return x;
    }

    public Call<List<Mesajcevappojo>> cevaplistem(String uye_id)
    {
        Call<List<Mesajcevappojo>> y=getRestApiClient().cevap(uye_id);
        return y;
    }
}
