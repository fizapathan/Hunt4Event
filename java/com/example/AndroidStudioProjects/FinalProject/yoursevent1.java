package com.example.AndroidStudioProjects.FinalProject;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nitika.FinalProject.R;

public class yoursevent1 extends AppCompatActivity {
    Button evebt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoursevent1);
        evebt1=(Button)findViewById(R.id.bun3);
        evebt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(yoursevent1.this,Yoursevent.class));
            }
        });
    }
}
