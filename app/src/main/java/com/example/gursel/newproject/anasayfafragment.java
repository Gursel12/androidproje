package com.example.gursel.newproject;



import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class anasayfafragment extends Fragment {

    View view;
    Button btnSonuc,btndoktors,btnembrio,btntedavi,btnilac,btniletisims;
    SharedPreferences sharedPreferences;
    String uye_id;
    TextView Phone,emaillink;
    SharedPreferences.Editor editor;




    public anasayfafragment(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.anasayfa_fragment, container, false);
        sharedPreferences=getContext().getSharedPreferences("giris",0);
        uye_id=sharedPreferences.getString("pno",null);

        tanimla();


        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {

            // true if the listener has consumed the event, false otherwise.
            // the key event happens twice, when pressing and taking off.
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);
                dialog.setCancelable(false);
                dialog.setMessage(""+getString(R.string.cikisevethayir));
                dialog.setPositiveButton(""+getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {





                        sharedPreferences = getContext().getSharedPreferences("giris", 0);
                        editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();

                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);




                    }
                }).setNegativeButton(""+getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();


        return true;
            }
        });



        return view;
    }





    public void tanimla()
    {

        btnSonuc=(Button) view.findViewById(R.id.btnlabsonuc);
        btndoktors=(Button)view.findViewById(R.id.btndoktor);
        btnembrio=(Button)view.findViewById(R.id.btnembrioresim);
        btntedavi=(Button)view.findViewById(R.id.btntedavi);
        btnilac=(Button)view.findViewById(R.id.btnilaclar);

        btniletisims=(Button) view.findViewById(R.id.btniletisims);









        btnSonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionlabsonuc();


            }
        });
        btnembrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionembrioresimlerim();

            }
        });
        btnilac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionilaclarim();
            }
        });
        btntedavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actiontedavilerim();
            }
        });

        btndoktors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actiondoktor();
            }
        });
        btniletisims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actioniletisim();
            }
        });
    }



    public void actionlabsonuc()
    {

       // Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new labsonucfragment());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new labsonucfragment(),null).addToBackStack(null).commit();


    }

    private void actionembrioresimlerim()
    {

        //Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new embrio_fragment());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new embrio_fragment(),null).addToBackStack(null).commit();
    }

    private void actiontedavilerim()
    {

        //Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new tedavi_fragment());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new tedavi_fragment(),null).addToBackStack(null).commit();
    }

    private void actionilaclarim()
    {

        //Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new ilac_fragment());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new ilac_fragment(),null).addToBackStack(null).commit();
    }




    private void actiondoktor()
    {
        //Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new doktorfragment());

        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new doktorfragment(),null).addToBackStack(null).commit();
    }
    private void actioniletisim()
    {

        //Changefragment changefragment=new Changefragment(getContext());
        //changefragment.change(new ilac_fragment());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.framelayout,new iletisim_fragment(),null).addToBackStack(null).commit();
    }


}
