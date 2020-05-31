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

public class signup2 extends AppCompatActivity {
    EditText ede4,ede5,ede6;
    Button button3;
    myclass obj;
    public int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        startconf();
        obj=new myclass(this);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=ede4.getText().toString();
                String email=ede5.getText().toString();
                String password=ede6.getText().toString();


                if(!isValidname(uname))
                {
                    ede4.setError("Name can't be empty ");
                }

                if (!isValidEmail(email))
                {
                    ede5.setError("Invalid Email");
                    return;

                }
                if(!isValidPassword(password))
                {
                    ede6.setError("Password is too small ");
                }



                try
                {

                    if(obj.adduser(uname,email,password))

                    {
                        showmsg("User Added Successfully");

                        startActivity(new Intent(signup2.this,login.class));
                    }
                    else
                    {
                        showmsg("user Not Added");
                    }
                }
                catch (Exception ex)
                {
                    showmsg(ex.getMessage());
                }
            }
        });
    }
    public void startconf()
    {
        ede4=findViewById(R.id.ed4);
        ede5=findViewById(R.id.ed5);
        ede6=findViewById(R.id.ed6);

        button3=findViewById(R.id.bdt3);
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
