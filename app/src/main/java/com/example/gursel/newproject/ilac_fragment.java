package com.example.gursel.newproject;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gursel.newproject.Adaptor.adaptor_ilac;
import com.example.gursel.newproject.Adaptor.adaptor_labsatir;
import com.example.gursel.newproject.Models.Labsatirpojo;
import com.example.gursel.newproject.Models.ilacpojo;
import com.example.gursel.newproject.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ilac_fragment extends Fragment {


    public ilac_fragment() {
    }

    View view;
    SharedPreferences sharedPreferences;
    String uye_id;
    ListView listView;
    List<ilacpojo> list;



    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.ilac_fragment, container, false);
        sharedPreferences = getContext().getSharedPreferences("giris", 0);
        uye_id = sharedPreferences.getString("pno", null);

        tanimla();

        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorScheme(R.color.blue, R.color.purple, R.color.green, R.color.orange);
        pullToRefresh.setProgressBackgroundColorSchemeColor(R.color.green);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ilac_istek(); // your code
                pullToRefresh.setRefreshing(false);
            }
        });
        return view;
    }

    public void tanimla()
    {
        listView=(ListView) view.findViewById(R.id.ilaclistview);


        ilac_istek();
    }


    private void ilac_istek()
    {
        list=new ArrayList<>();

        Call<List<ilacpojo>> ilaccall=ManagerAll.getOurInstance().ilaclarim(uye_id);
        ilaccall.enqueue(new Callback<List<ilacpojo>>() {
            @Override
            public void onResponse(Call<List<ilacpojo>> call, Response<List<ilacpojo>> response) {

                if (response.isSuccessful())
                {
                        Log.i("ilac",response.body().toString());

                        list=response.body();
                        adaptor_ilac adp=new adaptor_ilac(list,getContext());
                        listView.setAdapter(adp);

                }


            }

            @Override
            public void onFailure(Call<List<ilacpojo>> call, Throwable t) {

            }
        });
    }






}