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

public class DtlUsrInEh extends AppCompatActivity {
    String m="";
    int id;
    EditText txted1;
    Button ntbn1;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtl_usr_in_eh);
        txted1=(EditText) findViewById(R.id.Dltedt1);
        ntbn1=(Button)findViewById(R.id.dltbn1);
        obj=new myclass(this);
        m=getIntent().getStringExtra("val1");
        id=Integer.parseInt(m);

        Cursor c=obj.getuserineh(m);
        int name=c.getColumnIndex("uname");
        while(c.moveToNext())
        {
            txted1.setText(c.getString(name));
        }

        ntbn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname= txted1.getText().toString();
                if(!isValiduname(uname))
                {
                    txted1.setError("Name can't be empty ");
                }
                AlertDialog.Builder ab=new AlertDialog.Builder(DtlUsrInEh.this);
                ab.setTitle("Delete User");
                ab.setMessage("Sure,do you want to delete?");

                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try
                        {
                            if(obj.deleteusernameineh(id))
                            {
                                startActivity(new Intent(DtlUsrInEh.this,ShowUsrInEH.class));
                            }
                            else
                            {
                                showmsg("User Not Deleted.");
                            }
                        }
                        catch (Exception ex)
                        {
                            showmsg("Unable to Delete User.");
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

    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private  boolean isValiduname(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
}
