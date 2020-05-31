package com.example.android.finalproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.login;
//import com.example.android.finalproject.MapsActivity;
import com.example.AndroidStudioProjects.FinalProject.userbook;
import com.example.nitika.FinalProject.R;
import android.support.design.widget.FloatingActionButton;

import android.view.View;
public class MainActivity extends AppCompatActivity {

    //private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       /* Button btn = (Button) findViewById(R.id.payment);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                payment(v);
            }
        });
        */
    }

    public void payment(View v) {
        Intent intent = new Intent(this, userbook.class);
        startActivity(intent);
    }
       /* Button btn = (Button) findViewById(R.id.mapbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMapsActivity();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view,"Event added to your favourites",Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
    }*/
/*
    public void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
*/
    }


/**
 *
 * button.setOnClickListener(new View.onClickListener(){
 public void onClick(View view){

 }
 });



 private View.OnClickListener getButtonOnClickListener() = return new View.OnClickListener() {
@Override
public void onClick(View view) {
button = (Button) findViewById(R.id.button);
openMapsActivity();
}
};

 make_move.setOnClickListener(btnClick);

 */

/**

 package com.example.android.maps;


 }*/

/*

 requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Thread.sleep(3000);
                }
                catch(Exception ex)
                {
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                finally {
                    startActivity(new Intent(MainActivity.this,login.class));
                }
            }
        });
        t.start();

 */