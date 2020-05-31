package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class showyourevents extends AppCompatActivity {
    ListView shevls1;
    ArrayList<String> shev1, shev2;
    myclass obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showyourevents);

        shevls1 = findViewById(R.id.urevels1);
        obj = new myclass(this);
        shev1 = new ArrayList<String>();
        shev2= new ArrayList<String>();

        ArrayAdapter arrayAdapter = new ArrayAdapter(showyourevents.this, android.R.layout.simple_list_item_1, shev1);

        Cursor c = obj.showeve();

        // int eventdescription = c.getColumnIndex("eventdescription");

        //int id = c.getColumnIndex("etid");
        try {
            while (c.moveToNext()) {
                shev1.add(c.getString(1));
                shev2.add(c.getString(0));
                // list1.add(c.getString(1));
            }

            shevls1.setAdapter(arrayAdapter);

            shevls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = shev2.get(i);

                    Intent intent = new Intent(showyourevents.this, shwurevedetail.class);

                    // Toast.makeText(ShowAct.this, "The id:"+m, Toast.LENGTH_SHORT).show();
                    intent.putExtra("val1", m);

                    startActivity(intent);
                }
            });
        } catch (Exception ex) {

        }
    }
}


