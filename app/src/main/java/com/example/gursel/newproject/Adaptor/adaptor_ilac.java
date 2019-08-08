package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.ilacpojo;
import com.example.gursel.newproject.R;

import java.util.List;

public class adaptor_ilac extends BaseAdapter {

    List<ilacpojo> list;
    Context context;

    public adaptor_ilac(List<ilacpojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {

        return list.size();

    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_ilac,parent,false);

        TextView tarih,ilac;

        tarih=convertView.findViewById(R.id.txtilactarih);
        ilac=convertView.findViewById(R.id.txtilacadi);




        if (list.get(position).getTarih()!=null && list.get(position).getIlacadi()!=null)
            {

                 tarih.setText("" + list.get(position).getTarih().toString());
                 ilac.setText("" + list.get(position).getIlacadi().toString());

            }

        return convertView;
    }



}
