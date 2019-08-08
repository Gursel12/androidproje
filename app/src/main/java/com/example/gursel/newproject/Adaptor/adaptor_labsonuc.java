package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.Labsonucpojo;
import com.example.gursel.newproject.R;

import java.util.List;

public class adaptor_labsonuc  extends BaseAdapter{

    List<Labsonucpojo> list;
    Context context;


    public adaptor_labsonuc(List<Labsonucpojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return  list.size();
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

        convertView= LayoutInflater.from(context).inflate(R.layout.adp_labsonuc,parent,false);

        TextView txtTarih,txtTetkik,txtclik,txtTest,txtSonuc;

        txtTarih=convertView.findViewById(R.id.txttarih);
        txtTetkik=convertView.findViewById(R.id.txttetkikadi);
        txtclik=convertView.findViewById(R.id.txtclik);


        if ( list.get(position).getTest()!=null && list.get(position).getTarih()!=null)
        {

            txtTarih.setText(""+list.get(position).getTarih().toString());
            txtTetkik.setText(""+list.get(position).getTest().toString());
            txtclik.setText(txtclik.getText());

        }
        else
        {
            convertView.setVisibility(View.GONE);

        }

        return convertView;
    }



}
