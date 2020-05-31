package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class Categoryeh extends AppCompatActivity {
    //EditText ct1;
    Button ctn1,ctn2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryeh);
        //ct1=(EditText)findViewById(R.id.cet1);
        ctn2 =(Button) findViewById(R.id.cb2);
        ctn1=(Button)findViewById(R.id.cb1);
        obj=new myclass(this);

        ctn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Categoryeh.this,Yoursevent.class));
                //startActivity(new Intent(Categoryeh.this,catshow.class));
            }
        });

        ctn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Categoryeh.this,shwurevedetail.class));
                //startActivity(new Intent(Categoryeh.this,catshow.class));
            }
        });

    }


     /*   ctn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catname=ct1.getText().toString();
                if(!isValidname(catname))
                {
                    ct1.setError("Name can't be empty ");
                }

                try
                {
                    if (isValidname(catname))
                    if(obj.addcat(catname))
                    {
                        showmsg("Category Added Succesfully");
                    }
                }
                catch (Exception ex)
                {
                    showmsg(ex.getMessage());
                }



            }
        });
        */

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
}
