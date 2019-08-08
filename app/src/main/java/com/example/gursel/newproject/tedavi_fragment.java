package com.example.gursel.newproject;


import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.gursel.newproject.Models.Tedavipojo;
import com.example.gursel.newproject.RestApi.ManagerAll;
import com.example.gursel.newproject.Adaptor.adaptor_tedavi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class tedavi_fragment extends Fragment  {

    View view;
    SharedPreferences sharedPreferences;
    String uye_id;
    ListView listView;
    List<Tedavipojo> list;
    ProgressDialog progressDialog;

    Fragment fragment;

    public tedavi_fragment() {

    }



    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.tedavi_fragment, container, false);
        sharedPreferences=getContext().getSharedPreferences("giris",0);
        uye_id=sharedPreferences.getString("pno",null);
        tanimla();

        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorScheme(R.color.blue, R.color.purple, R.color.green, R.color.orange);
        pullToRefresh.setProgressBackgroundColorSchemeColor(R.color.green);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                istek(); // your code
                pullToRefresh.setRefreshing(false);
            }
        });








        return view;
    }



    public void tanimla()
    {
        listView=view.findViewById(R.id.listviewtedavi);
        istek();

    }

    public void istek()
    {
        progressDialog = new ProgressDialog(getContext(), R.style.AlertDialogStyle);
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.show();
        list=new ArrayList<>();
        Call<List<Tedavipojo>> x= ManagerAll.getOurInstance().tedavilerim(uye_id);
        x.enqueue(new Callback<List<Tedavipojo>>() {
            @Override
            public void onResponse(Call<List<Tedavipojo>> call, Response<List<Tedavipojo>> response) {

                if (response.isSuccessful())
                {
                    Log.i("dene",response.body().toString());
                    list=response.body();
                    adaptor_tedavi adp=new adaptor_tedavi(list,getContext());
                    listView.setAdapter(adp);
                    progressDialog.cancel();

                }
            }

            @Override
            public void onFailure(Call<List<Tedavipojo>> call, Throwable t) {

            }
        });
    }

}
