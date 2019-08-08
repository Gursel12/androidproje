package com.example.gursel.newproject.Adaptor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.gursel.newproject.Models.Embrioresimpojo;
import com.example.gursel.newproject.R;
import com.example.gursel.newproject.RestApi.BaseUrl;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class adaptor_embrio extends BaseAdapter {

    List<Embrioresimpojo> list;
    Context context;




    public adaptor_embrio(List<Embrioresimpojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {

        try {

            return list.size();

        }catch (Exception e)
        {

        }

       return 0;
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


        convertView=LayoutInflater.from(context).inflate(R.layout.adp_embrio,parent,false);

        TextView tarih=convertView.findViewById(R.id.txtembriotarih);
        TextView bos=convertView.findViewById(R.id.txtembribos);


        ImageView img=convertView.findViewById(R.id.imgembrio);


                  if (list.get(position).getResim()!=null && list.get(position).getTarih()!=null)
                  {

                      String base64String =""+list.get(position).getResim().toString();

                      if (base64String!=null)
                      {
                          byte [] decodedString = Base64.decode (base64String, Base64.DEFAULT);
                          Bitmap decodedByte = BitmapFactory.decodeByteArray (decodedString, 0, decodedString.length);
                          img.setImageBitmap (decodedByte);
                      }
                      img.setOnTouchListener(new ImageMatrixTouchHandler(convertView.getContext()));

                      tarih.setText(""+list.get(position).getTarih().toString());
                  }









        return convertView;
    }


}
