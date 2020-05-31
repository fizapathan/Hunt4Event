package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.UserDetailEvent;
import com.example.AndroidStudioProjects.FinalProject.UserGallery;
import com.example.AndroidStudioProjects.FinalProject.Userprofile;
import com.example.AndroidStudioProjects.FinalProject.login;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class userside2 extends AppCompatActivity {

    ListView cat1;
    ArrayList<String> usr1,usr2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userside2);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        obj=new myclass(this);


        obj = new myclass(this);
        cat1= (ListView) findViewById(R.id.eventlst);
        usr1 = new ArrayList<String>();
        usr2 = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(userside2.this, android.R.layout.simple_list_item_1, usr1);

        Cursor c = obj.showeve();

        // int eventdescription = c.getColumnIndex("eventdescription");

        //int id = c.getColumnIndex("etid");
        try {
            while (c.moveToNext()) {
                usr1.add(c.getString(1));
                usr2.add(c.getString(0));
                // list1.add(c.getString(1));
            }

            cat1.setAdapter(arrayAdapter);

            cat1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String m = usr2.get(i);

                    Intent intent = new Intent(userside2.this,UserDetailEvent.class);

                    // Toast.makeText(ShowAct.this, "The id:"+m, Toast.LENGTH_SHORT).show();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_gallery) {
            startActivity(new Intent(userside2.this,UserGallery.class));
            return true;
        }
*/
        if (id == R.id.action_profile) {
            startActivity(new Intent(userside2.this,Userprofile.class));
            return true;
        }

        if (id == R.id.action_logout) {
            startActivity(new Intent(userside2.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
