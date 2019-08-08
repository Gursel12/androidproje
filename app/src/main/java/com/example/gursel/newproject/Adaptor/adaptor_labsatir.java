package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.Labsatirpojo;
import com.example.gursel.newproject.Models.Labsonucpojo;
import com.example.gursel.newproject.R;

import java.util.List;

public class adaptor_labsatir extends BaseAdapter {

    List<Labsatirpojo> list;
    List<Labsonucpojo> x;
    Context  context;

    public adaptor_labsatir(List<Labsatirpojo> list, Context context) {
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

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_labsatir,parent,false);

        TextView tetkik,bulgu,lmin,lmax,mindeger,maxdeger;

        tetkik=convertView.findViewById(R.id.txtatetkik);
        bulgu=convertView.findViewById(R.id.txtbulgu);
        lmin=convertView.findViewById(R.id.txtlmin);
        lmax=convertView.findViewById(R.id.txtlmax);



        if (list.get(position).getAtetkik()!=null && list.get(position).getBulgu()!=null)
        {
            tetkik.setText(""+list.get(position).getAtetkik().toString());
            bulgu.setText(""+list.get(position).getBulgu().toString());

            if (list.get(position).getLmin()!=null && list.get(position).getLmax()!=null && list.get(position).getLmin().toString()!="" && list.get(position).getLmax().toString()!=" ") {

                lmin.setText("minimum "+" "+list.get(position).getLmin().toString());
                lmax.setText("maximum "+" "+list.get(position).getLmax().toString());

                }else
            {
                lmax.setText("");
                lmin.setText("");

            }


        }

        return convertView;
    }
}
