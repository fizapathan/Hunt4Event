package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class userinEH1 extends AppCompatActivity {
    Button userb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userin_eh1);
        userb1=(Button)findViewById(R.id.ehusrb1);

        userb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(userinEH1.this, "Select A User To Delete" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(userinEH1.this,ShowUsrInEH.class));
            }
        });
    }
}
