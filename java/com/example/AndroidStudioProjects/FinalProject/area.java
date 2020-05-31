package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.nitika.FinalProject.R;

public class area extends AppCompatActivity {
    EditText at1;

    myclass obj;
    Button bn1,bn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        at1 = (EditText) findViewById(R.id.aet1);
        bn1 = (Button) findViewById(R.id.sb1);
        bn2 = (Button) findViewById(R.id.sb2);
        obj = new myclass(this);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String areaname = at1.getText().toString();

                try {

                    if (obj.addarea(areaname)) {
                        showmsg("Area Added Succesfully");
                    }
                } catch (Exception ex) {
                    showmsg("Unable to Add Area");             }
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(area.this, Viewarea.class));
            }
        });
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    }

