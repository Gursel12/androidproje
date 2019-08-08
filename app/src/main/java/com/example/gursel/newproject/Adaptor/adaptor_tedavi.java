package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.Tedavipojo;
import com.example.gursel.newproject.R;

import java.util.List;


public class adaptor_tedavi extends BaseAdapter {

    List<Tedavipojo> lists;
    Context context;

    public adaptor_tedavi(List<Tedavipojo> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_tedavi,parent,false);

        TextView tarih,islem;

        tarih=convertView.findViewById(R.id.txttedavitarih);
        islem=convertView.findViewById(R.id.txttedaviislem);


        if (lists.get(position).getKislem()!=null && lists.get(position).getKtarih()!=null)
        {


            tarih.setText(" "+lists.get(position).getKtarih().toString());
            islem.setText(" "+lists.get(position).getKislem().toString());
        }



        return convertView;
    }
}
