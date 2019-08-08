package com.example.gursel.newproject;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gursel.newproject.Adaptor.adaptor_labsatir;
import com.example.gursel.newproject.Models.Labsatirpojo;
import com.example.gursel.newproject.Models.Labsonucpojo;
import com.example.gursel.newproject.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class satir_fragment extends Fragment {


     View view;
     List<Labsatirpojo> list_pojo;

     ListView listViewx;
     String uye_id,guids,guid;
     ListView listView;
    ProgressDialog progressDialog;

    SharedPreferences sharedPreferences;





    public satir_fragment() {

    }




    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_satir, container, false);
        sharedPreferences=getContext().getSharedPreferences("giris",0);
        uye_id=sharedPreferences.getString("pno",null);
        guids=sharedPreferences.getString("guid",null);
        tanimla();


        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorScheme(R.color.orange, R.color.purple, R.color.green, R.color.blue);
        pullToRefresh.setProgressBackgroundColorSchemeColor(R.color.green);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                istek_satir(); // your code
                pullToRefresh.setRefreshing(false);
            }
        });



        return view;
    }

    public void tanimla()
    {
        listViewx=view.findViewById(R.id.listviewsatir);

        istek_satir();






    }

    private void istek_satir()
    {
        progressDialog = new ProgressDialog(getContext() ,R.style.AlertDialogStyle);
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.show();

        list_pojo =new ArrayList<>();
        Call<List<Labsatirpojo>> m=ManagerAll.getOurInstance().labsatir(guids);
        m.enqueue(new Callback<List<Labsatirpojo>>() {
            @Override
            public void onResponse(Call<List<Labsatirpojo>> call, final Response<List<Labsatirpojo>> response) {

                if (response.isSuccessful())
                {

                    Log.i("satir",response.body().toString());

                    list_pojo=response.body();
                    adaptor_labsatir sdp=new adaptor_labsatir(list_pojo,getContext());
                    listViewx.setAdapter(sdp);
                    progressDialog.cancel();

                }
            }

            @Override
            public void onFailure(Call<List<Labsatirpojo>> call, Throwable t) {

            }
        });
    }

}
