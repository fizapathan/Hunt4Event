package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nitika.FinalProject.R;

public class ehuser extends AppCompatActivity {
    Button bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehuser);
        bt3=(Button)findViewById(R.id.b3);
        bt4=(Button)findViewById(R.id.b4);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ehuser.this,signup1.class));
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ehuser.this,signup2.class));
            }
        });

    }
}
