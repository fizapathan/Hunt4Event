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

public class credit extends AppCompatActivity {

    TextView uc1,uc2,uc3,uc4;
    TextView ccet1,ccet2;
    Spinner csp1,csp2;
    String ename="",eprice="",cname="",uid="",uname="",ehid="",eid="",mode="";
    myclass obj;
    int amount=0;

    ArrayList<String> list1,list2;
    ArrayAdapter a1,a2;

    SharedPreferences sharedPreferences;

    public static final String Mypreferences="MyLogin";
    public  static final String UserID="userkey";
    public  static final String UserName="usernamekey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

      /*  android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/




        startconf();
        obj=new myclass(this);
        ename=getIntent().getStringExtra("ename");
        eprice=getIntent().getStringExtra("eprice");
        cname=getIntent().getStringExtra("cname");
        eid=getIntent().getStringExtra("eid");
        mode=getIntent().getStringExtra("mode");
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();

        sharedPreferences=getSharedPreferences(Mypreferences, Context.MODE_PRIVATE);
        uid=sharedPreferences.getString(UserID,"");
        uname=sharedPreferences.getString(UserName,"");
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
        a1=new ArrayAdapter(credit.this,android.R.layout.simple_list_item_1,list1);
        csp1.setAdapter(a1);

        list2.add("--YEAR--");
        list2.add("2018");
        list2.add("2019");
        list2.add("2020");
        list2.add("2021");
        list2.add("2022");
        list2.add("2023");
        a2=new ArrayAdapter(credit.this,android.R.layout.simple_list_item_1,list2);
        csp2.setAdapter(a2);


        uc1.setText(uname);
        uc2.setText(cname);
        uc3.setText(ename);
        uc4.setText(eprice);

    }


    public void startconf()
    {
        uc1=findViewById(R.id.uc1);
        uc2=findViewById(R.id.uc2);

        uc3=findViewById(R.id.uc3);

        uc4=findViewById(R.id.uc4);
        ccet1=findViewById(R.id.ccet1);
        ccet2=findViewById(R.id.ccet2);
        csp1=findViewById(R.id.csp1);
        csp2=findViewById(R.id.csp2);
    }
    public void pay(View view)
    {
        // Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        String cardnum=ccet1.getText().toString();
        String cvv=ccet2.getText().toString();
        //Toast.makeText(this, "Your Booking Successfully Done", Toast.LENGTH_SHORT).show();

        if(!isValidnum(cardnum))
        {
            ccet1.setError("Card Number must be 16 digit ");
        }

        if(!isValidcvv(cvv))
        {
            ccet2.setError("CVV Number must be 3 digit ");
        }
        try
        {
            if(isValidnum(cardnum) && isValidcvv(cvv)) {
                Toast.makeText(this, "Your Booking Successfully Done", Toast.LENGTH_SHORT).show();
                if (obj.addbook(uid,eid, eprice, mode)) {
                    Toast.makeText(this, uid + "and" + ehid + "and" + eid + "and" + eprice + "and" + mode, Toast.LENGTH_SHORT).show();
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
        if(c.length()==16 )
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
            startActivity(new Intent(credit.this,UserGallery.class));
            return true;
        }
*/
        if (id == R.id.action_profile) {
            startActivity(new Intent(credit.this,Userprofile.class));
            return true;
        }

        if (id == R.id.action_logout) {
            startActivity(new Intent(credit.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
