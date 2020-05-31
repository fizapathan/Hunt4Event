package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class userside3 extends AppCompatActivity {
    GridView gdv1;
    ArrayList<String> gdw1,gdw2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userside3);


        obj = new myclass(this);
        gdv1= (GridView) findViewById(R.id.gv1);
        gdw1 = new ArrayList<String>();
        gdw2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(userside3.this, android.R.layout.simple_list_item_1, gdw1);

        Cursor c = obj.showgalleryinusr();

        int name = c.getColumnIndex("gname");
        int id = c.getColumnIndex("gid");

        try {
            while (c.moveToNext()) {
                //    Toast.makeText(this, c.getCount(), Toast.LENGTH_SHORT).show();
                gdw1.add(c.getString(name));
                gdw2.add(c.getString(id));
            }
            gdv1.setAdapter(arrayAdapter);
            gdv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m= gdw2.get(i);

                    //  Intent intent=new Intent(userside3.this,userside2.class);
                    // intent.putExtra("val1",m);
                    //Toast.makeText(userside3.this, "The id="+m , Toast.LENGTH_SHORT).show();
                    // startActivity(intent);
                }
            });

        }
        catch (Exception ex)
        {
            //Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}

