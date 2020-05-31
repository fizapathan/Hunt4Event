package com.example.AndroidStudioProjects.FinalProject;

/**
 * Created by Nazim Patham on 24-03-2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nitika.FinalProject.R;

public class userbook extends AppCompatActivity {
    TextView te1;
    Button tbn1,tbn2;

    String m="",ename="",eprice="",uid="",uname="",eid="",mode="",cname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userbook);
     /*   android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        startconf();
        ename=getIntent().getStringExtra("ename");
        eprice=getIntent().getStringExtra("eprice");
        cname=getIntent().getStringExtra("cname");
        eid=getIntent().getStringExtra("eid");

        tbn1=(Button) findViewById(R.id.button1);
        tbn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userbook.this,credit.class));
            }
        });

        tbn1=(Button) findViewById(R.id.button2);
        tbn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userbook.this,debit.class));
            }
        });
    }


    public  void credit(View view)
    {
        Intent intent=new Intent(userbook.this,credit.class);
        intent.putExtra("eid",eid);
        intent.putExtra("ename",ename);
        intent.putExtra("eprice",eprice);
        intent.putExtra("cname",cname);
        intent.putExtra("eid",m);
        intent.putExtra("mode","credit");
        startActivity(intent);
    }
    public  void debit(View view)
    {

        Intent intent=new Intent(userbook.this,debit.class);
        intent.putExtra("eid",eid);
        intent.putExtra("ename",ename);
        intent.putExtra("eprice",eprice);
        intent.putExtra("cname",cname);
        intent.putExtra("eid",m);
        intent.putExtra("mode","debit");

        startActivity(intent);

    }
    public void startconf()
    {
        te1=(TextView)findViewById(R.id.txv3);

        tbn1=(Button)findViewById(R.id.button);
        tbn2=(Button)findViewById(R.id.button2);

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
            startActivity(new Intent(userbook.this,UserGallery.class));
            return true;
        }
*/
        if (id == R.id.action_profile) {
            startActivity(new Intent(userbook.this,Userprofile.class));
            return true;
        }

        if (id == R.id.action_logout) {
            startActivity(new Intent(userbook.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
