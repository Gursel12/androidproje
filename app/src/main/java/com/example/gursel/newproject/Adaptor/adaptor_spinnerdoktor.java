package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.Spinnerdoktorpojo;
import com.example.gursel.newproject.R;

import java.util.List;

import retrofit2.Callback;

public class adaptor_spinnerdoktor extends BaseAdapter implements SpinnerAdapter {

    List<Spinnerdoktorpojo> list;
    Context context;

    public adaptor_spinnerdoktor(List<Spinnerdoktorpojo> list, Context context) {
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

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_spinner,parent,false);
        TextView doktor;
        doktor=convertView.findViewById(R.id.txtdoktor);
        doktor.setText(list.get(position).getKdoktor().toString());

        return doktor;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_springdropdown,parent,false);
        final TextView textView = (TextView)convertView.findViewById(R.id.dropdown);
        textView.setText(list.get(position).getKdoktor().toString());



        return convertView;
    }
}
