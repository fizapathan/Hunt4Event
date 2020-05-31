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

public class EventCategory extends AppCompatActivity {
    ListView evecatlst;
    ArrayList<String> clt1,cl2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_category);
        evecatlst=(ListView)findViewById(R.id.catlst1);
        obj=new myclass(this);

        clt1 = new ArrayList<String>();
        cl2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(EventCategory.this, android.R.layout.simple_list_item_1, clt1);

        Cursor c = obj.catgshow();

        int name = c.getColumnIndex("ecatname");
        int id = c.getColumnIndex("cid");
        try {
            while (c.moveToNext()) {
                clt1.add(c.getString(name));
                cl2.add(c.getString(id));
            }

            evecatlst.setAdapter(arrayAdapter);

            evecatlst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = cl2.get(i);

                    Intent intent = new Intent(EventCategory.this, Yoursevent.class);

                     Toast.makeText(EventCategory.this, "The id:"+m, Toast.LENGTH_SHORT).show();
                    intent.putExtra("val1", m);

                   startActivity(intent);
                }
            });
        } catch (Exception ex) {

        }
    }





    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
