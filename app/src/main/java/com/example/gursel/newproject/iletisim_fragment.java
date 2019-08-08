package com.example.gursel.newproject;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;


public class iletisim_fragment extends Fragment {

    public iletisim_fragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.iletisim_fragment, container, false);

        final TextView Phone,emaillink,whatsap;

        Phone=(TextView) view.findViewById(R.id.phone);
        emaillink=(TextView) view.findViewById(R.id.emaillink);
        whatsap=view.findViewById(R.id.iletisimwhatsapp);

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri


                        .parse("tel:+90 (242) 345 47 00"));


                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



                startActivity(sIntent);


            }
        });

        emaillink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailintent = new Intent(android.content.Intent.ACTION_SEND);
                emailintent.setType("plain/text");
                emailintent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"info@antalyaivf.com" });
                emailintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
                emailintent.putExtra(android.content.Intent.EXTRA_TEXT,"");
                startActivity(Intent.createChooser(emailintent, ""));

            }
        });

        whatsap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://wa.me/9005395866731");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        return view;
    }




}
