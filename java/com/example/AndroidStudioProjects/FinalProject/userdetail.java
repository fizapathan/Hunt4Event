package com.example.AndroidStudioProjects.FinalProject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class userdetail extends AppCompatActivity {
    String m="";
    int id;
    EditText usd1;
    Button usrdtl;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
        startconf();
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);


        Cursor c= obj.getuser(m);
         int name=c.getColumnIndex("uname");
         while(c.moveToNext())
         {
            usd1.setText(c.getString(name));
         }

        String uname=usd1.getText().toString();
        if(!isValidname(uname))
        {
            usd1.setError("Name can't be empty ");
        }

        usrdtl.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder ab= new AlertDialog.Builder(userdetail.this);
                 ab.setTitle("Delete User");
                 ab.setMessage("Sure, do you want to delete?");

                 ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         try
                         {
                          if(obj.deleteusername(id))
                          {
                              showmsg("User deleted");
                              startActivity(new Intent(userdetail.this,usershow.class));
                          }
                          else
                          {
                              showmsg("User not deleted");
                          }
                         }
                         catch (Exception ex)
                         {
                            showmsg(ex.getMessage());
                         }
                     }
                 });

                 ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                    AlertDialog ad=ab.create();
                    ad.show();
             }
         });


    }

    public void startconf()
    {
        usd1=findViewById(R.id.usdt1);
        usrdtl=findViewById(R.id.usdtb1);
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



}
