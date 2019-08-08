package com.example.gursel.newproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onesignal.OneSignal;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    String Navheadertxt, adi, soyadi,resim;
    TextView Navheadertextview,xisim;
    CircleImageView imge;

    public static  FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        Navheadertxt = sharedPreferences.getString("tckimlik", null);
        adi = sharedPreferences.getString("adi", null);
        soyadi = sharedPreferences.getString("soyadi", null);
        resim=sharedPreferences.getString("img", null);


        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


        fragmentManager=getSupportFragmentManager();

        if (findViewById(R.id.framelayout)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            anasayfafragment anasayfafragment=new anasayfafragment();
            fragmentTransaction.add(R.id.framelayout,anasayfafragment,null);
            fragmentTransaction.commit();

        }




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        xisim=toolbar.findViewById(R.id.idisim);
        xisim.setText(adi + " " + soyadi);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerview = navigationView.getHeaderView(0);


        try {
            byte [] decodedString = Base64.decode (resim, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray (decodedString, 0, decodedString.length);
            imge=headerview.findViewById(R.id.profil);
            imge.setImageBitmap (decodedByte);
            

        }catch (Exception e)
        {
            Log.i("error",e.toString());

        }



    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Anasayfa) {
            Intent ıntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(ıntent);

        } else if (id == R.id.btncikis) {

            sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
            editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent ıntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(ıntent);

            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

}
