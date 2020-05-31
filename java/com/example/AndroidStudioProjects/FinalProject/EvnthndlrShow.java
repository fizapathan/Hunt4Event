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

public class EvnthndlrShow extends AppCompatActivity {
    ListView ehsh;
    ArrayList<String> lsh1,lsh2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evnthndlr_show);
        ehsh=findViewById(R.id.ehsl1);
        obj=new myclass(this);
        lsh1=new ArrayList<String>();
        lsh2=new ArrayList<String>();

        ArrayAdapter arrayAdapter=new ArrayAdapter(EvnthndlrShow.this,android.R.layout.simple_list_item_1,lsh1);

        Cursor c=obj.ehshow();

        int name=c.getColumnIndex("name");
        int id=c.getColumnIndex("eid");
        try {
            while (c.moveToNext()) {
                lsh1.add(c.getString(name));
                lsh2.add(c.getString(id));
                // list1.add(c.getString(1));
            }

            ehsh.setAdapter(arrayAdapter);

            ehsh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String m = lsh2.get(i);


                    Intent intent=new Intent(EvnthndlrShow.this,eventdetail.class);
                    intent.putExtra("val1",m);
                    startActivity(intent);

                  //  Toast.makeText(EvnthndlrShow.this, "The id:" + m, Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception ex)
        {

        }

    }
}
