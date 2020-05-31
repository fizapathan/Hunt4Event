package com.example.AndroidStudioProjects.FinalProject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class catdetail extends AppCompatActivity {
    String m="";
    int id;
    EditText ecd1;
    Button bcd1,bcd2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catdetail);
        startconf();
        obj=new myclass(this);
        bcd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ecatname=ecd1.getText().toString();


                try
                {
                    /*The isValidname is removed in recent code*/
                    if (isValidname(ecatname))
                    if(obj.updatecatname(id,ecatname))
                    {
                        showmsg("Update Successfully");
                        startActivity(new Intent(catdetail.this,catshow.class));
                    }
                    else
                    {
                        showmsg("Update Failed");
                    }
                }
                catch (Exception ex)
                {
                    showmsg(ex.getMessage());
                }

            }
        });
        bcd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder ab = new AlertDialog.Builder(catdetail.this);
                ab.setTitle("Delete User");
                ab.setMessage("Sure Do you Want to delete?");

                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {
                            if (obj.deletecatname(id)) {
                                showmsg("User Deleted");
                                startActivity(new Intent(catdetail.this,catshow.class));
                            } else {
                                showmsg("User Not Deleted");
                            }
                        } catch (Exception ex) {
                            showmsg(ex.getMessage());
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
        ecd1=findViewById(R.id.cde1);
        bcd1=findViewById(R.id.cdbt1);
        bcd2=findViewById(R.id.cdbt2);
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
