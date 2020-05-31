package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nitika.FinalProject.R;

public class Eventhndlr1 extends AppCompatActivity {
    Button ehb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventhndlr1);
        ehb1=(Button)findViewById(R.id.ehsb1);
        ehb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Eventhndlr1.this,EvnthndlrShow.class));

            }
        });
    }
}
