package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class Subcategoryshow extends AppCompatActivity {
    String m="";
    int id;
    ListView sublst1;
    ArrayList<String> sub1,sub2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategoryshow);
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);
        sub1 = new ArrayList<String>();
        sub2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(Subcategoryshow.this, android.R.layout.simple_list_item_1, sub1);

        Cursor c= obj.getsubcat(m);

        int name = c.getColumnIndex("subcatname");
        int id = c.getColumnIndex("sbctid");
        try {
            while (c.moveToNext()) {
                sub1.add(c.getString(name));
                Toast.makeText(this, ""+sub1.add(c.getString(name)), Toast.LENGTH_SHORT).show();
                sub2.add(c.getString(id));
            }

            sublst1.setAdapter(arrayAdapter);

            sublst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = sub2.get(i);

                    Intent intent = new Intent(Subcategoryshow.this, Yoursevent.class);

                    // Toast.makeText(ShowAct.this, "The id:"+m, Toast.LENGTH_SHORT).show();
                    intent.putExtra("val1", m);

                    startActivity(intent);
                }
            });
        } catch (Exception ex) {

        }
    }
}
