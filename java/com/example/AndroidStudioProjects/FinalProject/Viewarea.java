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

public class Viewarea extends AppCompatActivity {
    ListView view1;
    ArrayList<String> la1,la2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewarea);
        view1=findViewById(R.id.lva1);
        obj=new myclass(this);
        la1=new ArrayList<String>();
        la2=new ArrayList<String>();
        ArrayAdapter arrayAdapter=new ArrayAdapter(Viewarea.this,android.R.layout.simple_list_item_1,la1);

        Cursor c= obj.showarea();

        int name=c.getColumnIndex("areaname");
        int id=c.getColumnIndex("aaid");
        try {
            while (c.moveToNext()) {
                la1.add(c.getString(name));
                la2.add(c.getString(id));
                // list1.add(c.getString(1));
            }

            view1.setAdapter(arrayAdapter);
            view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = la2.get(i);

                    Intent intent = new Intent(Viewarea.this,DetailArea.class);

                    //  Toast.makeText(Viewarea.this, "The id:"+m, Toast.LENGTH_SHORT).show();
                    intent.putExtra("val1", m);

                    startActivity(intent);
                }

            });
        }

        catch (Exception ex)
        {
            Toast.makeText(Viewarea.this, "Sorry! Something went wrong.", Toast.LENGTH_SHORT).show();
        }
    }
}
