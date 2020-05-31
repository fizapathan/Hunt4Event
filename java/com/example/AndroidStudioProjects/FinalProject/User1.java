package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nitika.FinalProject.R;

public class User1 extends AppCompatActivity {
        Button usrb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);
        usrb1=(Button)findViewById(R.id.usb1);

        usrb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User1.this,usershow.class));
            }
        });
    }
}
