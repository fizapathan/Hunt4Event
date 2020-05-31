package com.example.AndroidStudioProjects.FinalProject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.UserGallery;
import com.example.AndroidStudioProjects.FinalProject.Userprofile;
import com.example.AndroidStudioProjects.FinalProject.login;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class debit extends AppCompatActivity {


    TextView ud1,ud2,ud3,ud4;
    TextView dbet1,dbet2;
    Spinner dbsp1,dbsp2;
    String ename="",eprice="",cname="",uid="",uname="",ehid="",eid="",mode="";

    myclass obj;

    ArrayList<String> list1,list2;
    ArrayAdapter a1,a2;

    SharedPreferences sharedPreferences;

    public static final String Mypreferences="MyLogin";
    public  static final String UserID="userkey";
    public  static final String UserName="usernamekey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
      /*
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/


        startconf();
        obj=new myclass(this);
        sharedPreferences=getSharedPreferences(Mypreferences, Context.MODE_PRIVATE);
        uid=sharedPreferences.getString(UserID,"");
        uname=sharedPreferences.getString(UserName,"");
        ename=getIntent().getStringExtra("ename");
        eprice=getIntent().getStringExtra("eprice");
        cname=getIntent().getStringExtra("cname");
        eid=getIntent().getStringExtra("eid");
        mode=getIntent().getStringExtra("mode");
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
        list1.add("--MONTH--");
        list1.add("January");
        list1.add("February");
        list1.add("March");
        list1.add("April");
        list1.add("May");
        list1.add("June");
        list1.add("July");
        list1.add("August");
        list1.add("September");
        list1.add("October");
        list1.add("November");
        list1.add("December");
        a1=new ArrayAdapter(debit.this,android.R.layout.simple_list_item_1,list1);
        dbsp1.setAdapter(a1);

        list2.add("--YEAR--");
        list2.add("2018");
        list2.add("2019");
        list2.add("2020");
        list2.add("2021");
        list2.add("2022");
        list2.add("2023");
        a2=new ArrayAdapter(debit.this,android.R.layout.simple_list_item_1,list2);
        dbsp2.setAdapter(a2);

        ud1.setText(uname);
        ud2.setText(cname);
        ud3.setText(ename);
        ud4.setText(eprice);



    }
    public void startconf()
    {
        ud1=findViewById(R.id.uc1);
        ud2=findViewById(R.id.uc2);

        ud3=findViewById(R.id.uc3);

        ud4=findViewById(R.id.uc4);
        dbet1=findViewById(R.id.ccet1);
        dbet2=findViewById(R.id.dbet2);
        dbsp1=findViewById(R.id.csp1);
        dbsp2=findViewById(R.id.dbsp2);


    }
    public void pay(View view)
    {
        String cardnum=dbet1.getText().toString();
        String cvv=dbet2.getText().toString();
        if(!isValidnum(cardnum))
        {
            dbet1.setError("Card Number must be 13 digit ");
        }

        if(!isValidcvv(cvv))
        {
            dbet2.setError("CVV Number must be 3 digit ");
        }

        // Toast.makeText(this, "Your Booking Successfully Done", Toast.LENGTH_SHORT).show();
        try
        {
            if(isValidnum(cardnum) && isValidcvv(cvv)) {
                //Toast.makeText(this, "Your Booking Successfully Done", Toast.LENGTH_SHORT).show();
                if (obj.addbook(uid,eid, eprice, mode)) {
                    Toast.makeText(this, "Your Booking Successfully Done", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Booking Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidnum(String c)
    {
        if(c.length()==13 )
        {
            return  true;
        }
        return  false;
    }

    private boolean isValidcvv(String c)
    {
        if(c.length()==3 )
        {
            return  true;
        }
        return  false;
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
            startActivity(new Intent(debit.this,UserGallery.class));
            return true;
        }
*/
        if (id == R.id.action_profile) {
            startActivity(new Intent(debit.this,Userprofile.class));
            return true;
        }

        if (id == R.id.action_logout) {
            startActivity(new Intent(debit.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
