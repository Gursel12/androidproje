package com.example.gursel.newproject;


import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gursel.newproject.Adaptor.adaptor_labsatir;
import com.example.gursel.newproject.Models.Labsatirpojo;
import com.example.gursel.newproject.Models.Labsonucpojo;
import com.example.gursel.newproject.RestApi.ManagerAll;
import com.example.gursel.newproject.Adaptor.adaptor_labsonuc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class labsonucfragment extends Fragment {

    View view;
    List<Labsonucpojo> list;
    List<Labsatirpojo> listem;
    ListView listView,vv;
    String atetkik,bulgu;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String uye_id,guids,guid;
    ProgressDialog progressDialog;




    public labsonucfragment(){};

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)  {

        view=inflater.inflate(R.layout.labsonuc_fragment, container, false);
        sharedPreferences=getContext().getSharedPreferences("giris",0);
        uye_id=sharedPreferences.getString("pno",null);











        tanimla();



        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorScheme(R.color.blue, R.color.purple, R.color.green, R.color.orange);
        pullToRefresh.setProgressBackgroundColorSchemeColor(R.color.green);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                istek();

                pullToRefresh.setRefreshing(false);
            }
        });



        return view;
    }

    public void tanimla()
    {

        listView=view.findViewById(R.id.listview);




        istek();



    }





    private void istek()
    {
        list=new ArrayList<>();
        listem=new ArrayList<>();


        progressDialog = new ProgressDialog(getContext() ,R.style.AlertDialogStyle);
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.show();

        Call<List<Labsonucpojo>> listCall= ManagerAll.getOurInstance().labsonuclarim(uye_id);
        listCall.enqueue(new Callback<List<Labsonucpojo>>() {
            @Override
            public void onResponse(Call<List<Labsonucpojo>> call, final Response<List<Labsonucpojo>> response) {

                if (response.isSuccessful())
                {
                    Log.i("sonuc",response.body().toString());

                    list=response.body();
                    adaptor_labsonuc adp=new adaptor_labsonuc(list,getContext());
                    listView.setAdapter(adp);



                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {





                               Log.i("sat",list.get(position).getGuid());

                              String uyeid = response.body().get(position).getGuid().toString();
                               sharedPreferences = getContext().getSharedPreferences("giris", 0);
                              SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("guid", uyeid);

                            editor.commit();
                            if (sharedPreferences.getString("guid", null) != null ) {

                                MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new satir_fragment(),null).addToBackStack(null).commit();

                            }






                        }
                    });

                    progressDialog.cancel();

                }

            }

            @Override
            public void onFailure(Call<List<Labsonucpojo>> call, Throwable t) {

            }
        });


    }




}
