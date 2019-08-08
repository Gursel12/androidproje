package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gursel.newproject.Models.Mesajcevappojo;
import com.example.gursel.newproject.R;

import java.util.List;

public class adaptor_mesajcevap extends BaseAdapter {

    List<Mesajcevappojo> list;
    Context context;

    public adaptor_mesajcevap(List<Mesajcevappojo> list, Context context) {
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

        convertView = LayoutInflater.from(context).inflate(R.layout.adp_mesajcevap, parent, false);
        TextView tarih, cevap,bekle,soru,sorutarih;
        tarih = (TextView) convertView.findViewById(R.id.txtmesajtarih);
        cevap = (TextView) convertView.findViewById(R.id.txtmesajcevap);
        soru=(TextView)convertView.findViewById(R.id.txtsoru);
        sorutarih=(TextView)convertView.findViewById(R.id.txtsorutarih);

        bekle =(TextView) convertView.findViewById(R.id.txtmesajbekle);




        if (list.get(position).getCevap()!=null && list.get(position).getCtarih()!=null && list.get(position).getTarih()!=null && list.get(position).getMesaj()!=null)
        {
            if (list.get(position).getCtarih().equals("0000-00-00"))
            {

                bekle.setText(" ");

            }else {
                tarih.setText("" + list.get(position).getCtarih().toString());
                cevap.setText("" + list.get(position).getCevap().toString());
                soru.setText(""+list.get(position).getMesaj().toString());
                sorutarih.setText(""+list.get(position).getTarih().toString());
            }
        }


        return convertView;
    }
}
