package com.example.android.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.login;
import com.example.nitika.FinalProject.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    Toast.makeText(SplashActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    startActivity(new Intent(SplashActivity.this, login.class));
                }
            }
        });
        t.start();
    }

}
