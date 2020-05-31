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

public class
shwurevedetail extends AppCompatActivity {
    String m="";
    int id;
    EditText e11,e22,e33,e44;
    Button b11,b22;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shwurevedetail);
        obj=new myclass(this);
        startconf();

        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);


        showmsg(m+""+id);

        Cursor c=obj.getevent(m);


        try {
            // int name = c.getColumnIndex("eventname");


            while (c.moveToNext()) {
                e11.setText(c.getString(1));
                e22.setText(c.getString(2));
                e33.setText(c.getString(6));
                e44.setText(c.getString(7));
                // e22.setText(c.getString());

            }
        }
        catch (Exception ex)
        {
           // showmsg(ex.getMessage());
        }
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eventname=e11.getText().toString();
                String eventdescription=e22.getText().toString();
                String eventdate=e33.getText().toString();
                String price=e44.getText().toString();


                try
                {
                    if(obj.updatevename(id,eventname,eventdescription,eventdate,price))
                    {
                        showmsg("Event name updated Successfully");
                        startActivity(new Intent(shwurevedetail.this,showyourevents.class));
                    }
                    else
                    {
                        showmsg("Update Failed");
                    }
                }
                catch (Exception ex)
                {
                    showmsg("Unable to Update");
                }

            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder ab = new AlertDialog.Builder(shwurevedetail.this);
                ab.setTitle("Delete Event");
                ab.setMessage("Sure Do you Want to delete?");

                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {
                            if (obj.deletearea(id)) {
                                showmsg("Event Deleted");
                                startActivity(new Intent(shwurevedetail.this,EventCategory.class));
                            } else {
                                showmsg("Event Not Deleted");
                            }
                        } catch (Exception ex) {
                            showmsg("Unable to Delete");
                        }

                    }
                });

                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog ad = ab.create();
                ad.show();

            }
        });


    }


    public void startconf()
    {
        e11=findViewById(R.id.ed11);
        e22=findViewById(R.id.ed22);
        e33=findViewById(R.id.ed33);
        e44=findViewById(R.id.ed44);
        b11=findViewById(R.id.bt11);
        b22=findViewById(R.id.bt22);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
