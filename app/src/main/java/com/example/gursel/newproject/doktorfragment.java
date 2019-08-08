package com.example.gursel.newproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gursel.newproject.Models.Mesajpojo;
import com.example.gursel.newproject.Models.Spinnerdoktorpojo;
import com.example.gursel.newproject.Adaptor.adaptor_spinnerdoktor;
import com.example.gursel.newproject.RestApi.ManagerAll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class doktorfragment extends Fragment {

    View view;
    Spinner spinner;

    List<Spinnerdoktorpojo> listem;
    adaptor_spinnerdoktor adaptor_spinnerdoktor;

    TextView txtsms;
    Button btngonder,btncevap,btnback;
    SharedPreferences sharedPreferences;
    String uye_id,uye_ad,uye_soyadi;

    TextView displayTextView;


   public  doktorfragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.doktor_fragment, container, false);

        sharedPreferences = getContext().getSharedPreferences("giris", 0);
        uye_id = sharedPreferences.getString("uyeid", null);



        tanimla();



        return view;
    }


    public void tanimla() {
        spinner = (Spinner) view.findViewById(R.id.cbmspinner);

         spinneristek();
         sec();


        txtsms = (TextView) view.findViewById(R.id.txtmesaj);
        btngonder = (Button) view.findViewById(R.id.btnmesajgonder);
        btncevap=(Button) view.findViewById(R.id.btncevap);



        btncevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Changefragment changefragment=new Changefragment(getContext());
                //changefragment.change(new cevap_fragment());

                MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new cevap_fragment(),null).addToBackStack(null).commit();
            }
        });
        add();



    }

    public void spinneristek() {
        listem = new ArrayList<>();
        Call<List<Spinnerdoktorpojo>> x = ManagerAll.getOurInstance().spdoktorlarim();
        x.enqueue(new Callback<List<Spinnerdoktorpojo>>() {
            @Override
            public void onResponse(Call<List<Spinnerdoktorpojo>> call, Response<List<Spinnerdoktorpojo>> response) {

                if (response.isSuccessful()) {
                    listem = response.body();
                    adaptor_spinnerdoktor = new adaptor_spinnerdoktor(listem, getContext());
                    spinner.setAdapter(adaptor_spinnerdoktor);





                }
            }

            @Override
            public void onFailure(Call<List<Spinnerdoktorpojo>> call, Throwable t) {

            }
        });
    }




    String doktor;


    public void add() {

        btngonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getContext().getSharedPreferences("giris", 0);
                uye_id = sharedPreferences.getString("pno", null);
                uye_ad=sharedPreferences.getString("adi",null);
                uye_soyadi=sharedPreferences.getString("soyadi",null);

                String x_ad=uye_ad.toString();
                String x_soyad=uye_soyadi.toString();

                String pno = uye_id.toString();
                String mesaj = txtsms.getText().toString();
                Date tarih = new Date();
                SimpleDateFormat bugun = new SimpleDateFormat("yyyy/MM/dd");


                String gtarih=bugun.format(tarih);

                Log.i("cevap",listem.toString());



                sec();

                String x=doktor.toString();



                if (!mesaj.equals("")) {


                    mesajistek(mesaj, pno,x,gtarih,x_ad,x_soyad);
                    deleteedittext();

                }else {
                    Toast.makeText(getContext(), ""+getString(R.string.smsbosvalue), Toast.LENGTH_LONG).show();

                }







            }
        });

    }

    public void deleteedittext() {
        txtsms.setText(" ");

    }

    public void mesajistek(String mesaj, String pno, String doktor,String tarih,String ad,String soyad) {

        Call<Mesajpojo> x = ManagerAll.getOurInstance().eklemesaj(mesaj, pno, doktor,tarih,ad,soyad);
        x.enqueue(new Callback<Mesajpojo>() {
            @Override
            public void onResponse(Call<Mesajpojo> call, Response<Mesajpojo> response) {

                Toast.makeText(getContext(), ""+getString(R.string.smssend), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Mesajpojo> call, Throwable t) {

            }
        });
    }


    public void sec()
    {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               //Toast.makeText(getContext(),listem.get(position).getKdoktor().toString(),Toast.LENGTH_LONG).show();
                Log.i("deger",spinner.getSelectedItem().toString());


                doktor= listem.get(position).getKdoktor().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}


