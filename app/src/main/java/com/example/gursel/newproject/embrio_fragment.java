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

import android.widget.Button;
import android.widget.ListView;



import com.example.gursel.newproject.Adaptor.adaptor_embrio;
import com.example.gursel.newproject.Models.Embrioresimpojo;
import com.example.gursel.newproject.RestApi.ManagerAll;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class embrio_fragment extends Fragment {


    public embrio_fragment(){};


    View view;
    ListView listView;
    List<Embrioresimpojo> list;
    SharedPreferences sharedPreferences;
    String uye_id;
    ProgressDialog progressDialog;



    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.embrio_fragment, container, false);

        sharedPreferences=getContext().getSharedPreferences("giris",0);
        uye_id=sharedPreferences.getString("pno",null);

        tanimla();

        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorScheme(R.color.blue, R.color.purple, R.color.green, R.color.orange);
        pullToRefresh.setProgressBackgroundColorSchemeColor(R.color.green);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                istekal(); // your code
                pullToRefresh.setRefreshing(false);
            }
        });

        return view;
    }

    public void tanimla()
    {
        listView=(ListView) view.findViewById(R.id.listviewembrio);

        istekal();


    }


    public  void istekal()
    {
        list=new ArrayList<>();

        progressDialog = new ProgressDialog(getContext(), R.style.AlertDialogStyle);
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.show();

        Call<List<Embrioresimpojo>> listCall= ManagerAll.getOurInstance().embrioResimlerim(uye_id);
        listCall.enqueue(new Callback<List<Embrioresimpojo>>() {
            @Override
            public void onResponse(Call<List<Embrioresimpojo>> call, Response<List<Embrioresimpojo>> response) {

                if (response.isSuccessful())
                {

                    list=response.body();
                    adaptor_embrio adp=new adaptor_embrio(list,getContext());
                    listView.setAdapter(adp);

                    progressDialog.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Embrioresimpojo>> call, Throwable t) {

            }
        });






    }


}
