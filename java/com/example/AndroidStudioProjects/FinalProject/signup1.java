package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup1 extends AppCompatActivity {
    EditText ett1,ett2,ett3;
    Button btn2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        startconf();
        obj=new myclass(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ett1.getText().toString();
                String email=ett2.getText().toString();
                String password=ett3.getText().toString();



                if(!isValidname(name))
                {
                    ett1.setError("Name can't be empty ");
                }

                if (!isValidEmail(email))
                {
                    ett2.setError("Invalid Email");
                }
                if(!isValidPassword(password))
                {
                    ett3.setError("Password is too small ");
                }




                try
                {

                     if(obj.addeh(name,email,password))
                    {
                        showmsg("Event Handler Added Successfully");

                        startActivity(new Intent(signup1.this,login.class));
                    }
                    else
                    {
                        showmsg("Event Handler Not Added");
                    }
                }
                catch (Exception ex)
                {
                    showmsg("Unable to Add Event Handler");
                }
            }
        });
    }
    public void startconf()
    {
        ett1=findViewById(R.id.edt1);
        ett2=findViewById(R.id.edt2);
        ett3=findViewById(R.id.edt3);

        btn2=findViewById(R.id.bt2);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private  boolean isValidname(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
    private boolean isValidPassword(String p)
    {
        if(p!=null&&p.length()>6)
        {
            return  true;
        }
        return  false;
    }
    private boolean isValidEmail(String em) {
        String epattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(epattern);
        Matcher matcher = pattern.matcher(em);
        return matcher.matches();
    }



}
