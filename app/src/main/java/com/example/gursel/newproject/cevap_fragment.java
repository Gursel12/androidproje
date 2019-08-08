package com.example.gursel.newproject;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.gursel.newproject.Models.Mesajcevappojo;
import com.example.gursel.newproject.Adaptor.adaptor_mesajcevap;
import com.example.gursel.newproject.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class cevap_fragment extends Fragment {



    View view;
    String uye_id;
    SharedPreferences sharedPreferences;
    ListView listView;
    List<Mesajcevappojo> list;
    adaptor_mesajcevap adp;
    ProgressDialog progressDialog;

   public cevap_fragment(){}

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.cevap_fragment, container, false);

        sharedPreferences = getContext().getSharedPreferences("giris", 0);
        uye_id = sharedPreferences.getString("pno", null);

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






    public void  tanimla()
    {
        listView=(ListView) view.findViewById(R.id.listviewcevap);
        istek();




    }

    public  void istek()
    {

        progressDialog = new ProgressDialog(getContext() ,R.style.AlertDialogStyle);
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.show();
        list=new ArrayList<>();

        Call<List<Mesajcevappojo>> n= ManagerAll.getOurInstance().cevaplistem(uye_id);
        n.enqueue(new Callback<List<Mesajcevappojo>>() {
            @Override
            public void onResponse(Call<List<Mesajcevappojo>> call, Response<List<Mesajcevappojo>> response) {



                    if (response.isSuccessful()) {
                        list = response.body();
                        adp = new adaptor_mesajcevap(list, getContext());
                        listView.setAdapter(adp);
                        progressDialog.cancel();
                    }

            }

            @Override
            public void onFailure(Call<List<Mesajcevappojo>> call, Throwable t) {

            }
        });
    }


}
