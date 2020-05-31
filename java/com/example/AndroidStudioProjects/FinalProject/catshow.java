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

public class catshow extends AppCompatActivity {
    ListView cl1;
    ArrayList<String> lc1, lc2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catshow);
        cl1 = findViewById(R.id.csl1);
        obj = new myclass(this);
        lc1 = new ArrayList<String>();
        lc2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(catshow.this, android.R.layout.simple_list_item_1, lc1);

        Cursor c = obj.catgshow();

        int name = c.getColumnIndex("ecatname");
        int id = c.getColumnIndex("cid");
        try {
            while (c.moveToNext()) {
                lc1.add(c.getString(name));
                lc2.add(c.getString(id));
            }

            cl1.setAdapter(arrayAdapter);

            cl1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = lc2.get(i);

                    Intent intent = new Intent(catshow.this, catdetail.class);

                    // Toast.makeText(ShowAct.this, "The id:"+m, Toast.LENGTH_SHORT).show();
                    intent.putExtra("val1", m);

                    startActivity(intent);
                }
            });
        } catch (Exception ex) {

        }
    }
}
