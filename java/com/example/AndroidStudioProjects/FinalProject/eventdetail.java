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

public class eventdetail extends AppCompatActivity {
    String m="";
    int id;
    EditText eh1;
    Button bh1;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetail);
        startconf();
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);



        Cursor c= obj.geteh(m);
        int name=c.getColumnIndex("ename");

        while(c.moveToNext())
        {
            eh1.setText(c.getString(name));
        }
        bh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab= new AlertDialog.Builder(eventdetail.this);
                ab.setTitle("Delete Event handler");
                ab.setMessage("Sure, do you want to delete?");

                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try
                        {
                            if(obj.deleteehname(id))
                            {
                                showmsg("Event Handler deleted");
                                startActivity(new Intent(eventdetail.this,EvnthndlrShow.class));
                            }
                            else
                            {
                                showmsg("Event handler not deleted");
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
        eh1=findViewById(R.id.evdt1);
        bh1=findViewById(R.id.evhb1);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
