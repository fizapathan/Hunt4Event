package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.UserGallery;
import com.example.AndroidStudioProjects.FinalProject.Userprofile;
import com.example.AndroidStudioProjects.FinalProject.login;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.AndroidStudioProjects.FinalProject.userbook;
import com.example.nitika.FinalProject.R;

public class UserDetailEvent extends AppCompatActivity {
    Button evebtn1;
    TextView vw1,vw2,vw3,vw4,vw5,vw6,vw7,vw8;
    myclass obj;

    String m="",ename="",eprice="",uid="",uname="",eid="",mode="",cname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_event);//activity_main_page
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startconf();
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");

        Cursor c=obj.getevent(m);


        try {
            // int name = c.getColumnIndex("eventname");


            while (c.moveToNext()) {
                vw3.setText(c.getString(1));
                ename=c.getString(1);
                eprice=c.getString(7);
                cname=c.getString(2);
                vw5.setText(c.getString(2));
                vw7.setText(c.getString(6));
                vw8.setText(c.getString(7));

            }
        }
        catch (Exception ex)
        {
            //showmsg(ex.getMessage());
        }

        evebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserDetailEvent.this,userbook.class);
                intent.putExtra("ename",ename);
                intent.putExtra("eprice",eprice);
                intent.putExtra("cname",cname);
                intent.putExtra("eid",m);
                startActivity(intent);
            }
        });
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
        /*if (id == R.id.action_gallery) {
            startActivity(new Intent(UserDetailEvent.this,UserGallery.class));
            return true;
        }

        if (id == R.id.action_profile) {
            startActivity(new Intent(UserDetailEvent.this,Userprofile.class));
            return true;
        }
*/
        if (id == R.id.action_logout) {
            startActivity(new Intent(UserDetailEvent.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void startconf()
    {
        vw3=(TextView)findViewById(R.id.udet1);
        vw5=(TextView)findViewById(R.id.udet2);
        vw7=(TextView)findViewById(R.id.udet3);
        vw8=(TextView)findViewById(R.id.udet4);

        evebtn1=(Button)findViewById(R.id.bnt2);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }


}
