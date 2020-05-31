package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class subcategory extends AppCompatActivity {

    EditText subet1;
    Spinner subspn1;
    ArrayList<String> as1,as2;
    Button subbtn1;
    myclass obj;
    String m="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);
        obj = new myclass(this);
        startconf();
        subspn1 = (Spinner) findViewById(R.id.sctg1);
        as1 = new ArrayList<String>();
        as2 = new ArrayList<String>();
        subbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subcatname=subet1.getText().toString();

                try
                {

                    if(obj.addsubcat(subcatname))
                    {
                        showmsg("Subcategory Added Successfully");

                        // startActivity(new Intent(subcategory.this,class));
                    }
                    else
                    {
                        showmsg(" Not Added");
                    }
                }
                catch (Exception ex)
                {
                    showmsg(ex.getMessage());
                }
            }
        });

        Cursor c=obj.catgshow();

        int name = c.getColumnIndex("ecatname");
        int id = c.getColumnIndex("cid");

        try
        {

            while (c.moveToNext())
            {
                as1.add(c.getString(name));
                as2.add(c.getString(id));


            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(subcategory.this, android.R.layout.simple_list_item_1, as1);
            subspn1.setAdapter(arrayAdapter);

            subspn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    m=as2.get(i);
                    // startActivity(new Intent(subcategory.this,Subcategoryshow.class));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }


            });


        }
        catch (Exception ex)
        {
            showmsg(ex.getMessage());
        }


              /*    subbtn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String subcatname = subet1.getText().toString();

                    try {
                        if (obj.subactadd(subcatname)) {
                            showmsg("Subcategory added");
                        } else {
                            showmsg("Not added");
                        }
                    } catch (Exception ex) {
                        ex.getMessage();
                    }

                }
            }); */





    }


    public void startconf()
    {
        subet1=findViewById(R.id.sbctet1);
        subspn1=findViewById(R.id.sctg1);
        subbtn1=findViewById(R.id.sbctbt1);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
