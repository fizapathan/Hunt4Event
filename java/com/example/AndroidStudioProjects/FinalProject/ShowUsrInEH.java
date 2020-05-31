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

import com.example.AndroidStudioProjects.FinalProject.DtlUsrInEh;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class ShowUsrInEH extends AppCompatActivity {
    ListView usrls1;
    ArrayList<String> usehl1,usehl2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_usr_in_eh);
        obj=new myclass(this);
        usrls1=(ListView)findViewById(R.id.shwusrlst1);
        usehl1 = new ArrayList<String>();
        usehl2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(ShowUsrInEH.this, android.R.layout.simple_list_item_1, usehl1);

        Cursor c=obj.showuserineh();


        int name = c.getColumnIndex("uname");
        int id = c.getColumnIndex("uid");

        try {
            while (c.moveToNext()) {
                usehl1.add(c.getString(name));
                usehl2.add(c.getString(id));
            }
            usrls1.setAdapter(arrayAdapter);
            usrls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m= usehl2.get(i);

                    Intent intent=new Intent(ShowUsrInEH.this,DtlUsrInEh.class);
                    intent.putExtra("val1",m);
                    startActivity(intent);
                }
            });

        }
        catch (Exception ex)
        {

        }
    }

}

