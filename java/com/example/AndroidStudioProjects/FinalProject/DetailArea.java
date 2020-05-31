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

public class DetailArea extends AppCompatActivity {

    String m="";
    int id;
    Button asb1,asb2;
    EditText aet1;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_area);

        startconf();
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);

        //showmsg("The Uid:"+m);


        Cursor c=obj.getarea(m);

        int name=c.getColumnIndex("areaname");


        while (c.moveToNext())
        {
            aet1.setText(c.getString(name));

        }
        asb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String areaname=aet1.getText().toString();

                if(!isValidareaname(areaname))
                {
                    aet1.setError("Name can't be empty ");
                }

                try
                {
                    if(obj.updatearea(id,areaname))
                    {
                        showmsg("Update Successfully");
                        startActivity(new Intent(DetailArea.this,area.class));
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

        asb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder ab = new AlertDialog.Builder(DetailArea.this);
                ab.setTitle("Delete Area");
                ab.setMessage("Sure Do you Want to delete?");

                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {
                            if (obj.deletearea(id)) {
                                showmsg("Area Deleted");

                                //startActivity(new Intent(DetailArea.this,area.class));
                            } else {
                                showmsg("Area Not Deleted");
                            }
                        } catch (Exception ex) {
                            showmsg("Unable to Delete Area");
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
        aet1=findViewById(R.id.adt1);
        asb1=findViewById(R.id.asd1);
        asb2=findViewById(R.id.asd2);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private  boolean isValidareaname(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
}
