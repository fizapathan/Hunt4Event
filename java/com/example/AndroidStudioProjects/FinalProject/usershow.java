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

public class usershow extends AppCompatActivity {
    ListView showuser1;
    ArrayList<String> usra1,usra2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usershow);
        obj = new myclass(this);
        showuser1 = (ListView) findViewById(R.id.shls1);
        usra1 = new ArrayList<String>();
        usra2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(usershow.this, android.R.layout.simple_list_item_1, usra1);

        Cursor c = obj.showuser();

        int name = c.getColumnIndex("uname");
        int id = c.getColumnIndex("uid");

        try {
           while (c.moveToNext()) {
               usra1.add(c.getString(name));
               usra2.add(c.getString(id));
           }
           showuser1.setAdapter(arrayAdapter);
           showuser1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   String m= usra2.get(i);

                   Intent intent=new Intent(usershow.this,userdetail.class);
                   intent.putExtra("val1",m);
                   //Toast.makeText(usershow.this, "The id="+m , Toast.LENGTH_SHORT).show();
                   startActivity(intent);
               }
           });

        }
        catch (Exception ex)
        {

        }
    }
}
