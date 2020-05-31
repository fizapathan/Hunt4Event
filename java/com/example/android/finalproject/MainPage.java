package com.example.android.finalproject;

/**
 * Created by Nazim Patham on 19-03-2018.
 */

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.AndroidStudioProjects.FinalProject.login;
import com.example.DashboardFragment;
import com.example.HomeFragment;
import com.example.nitika.FinalProject.R;

public class MainPage extends AppCompatActivity {

    TextView textView;
    Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.content, new DashboardFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content, new NotificationFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content, new HomeFragment());
        tx.commit();
    }

    public void onClick(View view) {
        Button button2 = (Button) findViewById(R.id.button2);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button3 = (Button) findViewById(R.id.button3);

       // Button button5 = (Button) findViewById(R.id.button5);
        //Button button6 = (Button) findViewById(R.id.button6);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

      /*  button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });*/
    }

/*
        String textTitle="@string/note_title";
        String textContent="@string/note_description";
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default")
                //.setSmallIcon("@drawable/ic_notification_icon")
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    public void initChannels(Context context){
        if(Build.VERSION.SDK_INT < 26){
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default", "Channel name", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel Description");
        notificationManager.createNotificationChannel(channel);
    }
*/


 /*   public void get_main_event(View view) {
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }*/
}




/*
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPage.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        */


/*      String hf_button;
        hf_button = ((Button) view).getText().toString();
        if(hf_button.equals("@string/event_button")) {
            Intent intent1 = new Intent(this,MainActivity.class);
            startActivity(intent1);
        }
*/

/*      textView  = (TextView)findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEventActivity();
            }
        });

        public void openEventActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    */




        /**


*/