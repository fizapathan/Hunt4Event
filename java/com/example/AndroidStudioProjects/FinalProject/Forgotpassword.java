package com.example.AndroidStudioProjects.FinalProject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import com.example.nitika.FinalProject.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forgotpassword extends AppCompatActivity {
    EditText et1;
    myclass obj;
    String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        obj=new myclass(this);
        et1=findViewById(R.id.femail);


    }

    public void submit(View view)
    {
        String email=et1.getText().toString();



        Cursor c=obj.fpassword("select * from user where email='"+email+"'");
        try
        {
            while (c.moveToNext())
            {
                String password=c.getString(3);

            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mail to:"));
        intent.setType("text/plain");

        String to[]={email,"snrana2000@gmail.com" +
                ""};

        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Forgot Password");
        intent.putExtra(Intent.EXTRA_TEXT,"Your Password is: "+password);

        try
        {
            startActivity(new Intent(Intent.createChooser(intent,"send email")));
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    private boolean isValidEmail(String em)
    {
        String epattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern= Pattern.compile(epattern);
        Matcher matcher=pattern.matcher(em);
        return  matcher.matches();
    }

}
