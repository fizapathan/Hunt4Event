package com.example.AndroidStudioProjects.FinalProject;

/**
 * Created by Nazim Patham on 24-03-2018.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class Userprofile extends AppCompatActivity {

    EditText et1;
    myclass obj;

    String uid="";
    SharedPreferences sharedPreferences;

    public static final String Mypreferences="MyLogin";
    public  static final String UserID="userkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sharedPreferences=getSharedPreferences(Mypreferences, Context.MODE_PRIVATE);
        uid=sharedPreferences.getString(UserID,"");

        et1=findViewById(R.id.uset1);
        obj=new myclass(this);

        Cursor c=obj.fetchuser(uid);

        try
        {
            while (c.moveToNext())
            {
                et1.setText(c.getString(1));
            }
        }
        catch (Exception ex)
        {
            //Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void editprofile(View view)
    {
        String name=et1.getText().toString();

        if(!isValidname(name))
        {
            et1.setError("Name can't be empty ");
        }



        try
        {
            if (isValidname(name)) {
                if (obj.updateuser(uid, name)) {
                    Toast.makeText(this, "Profile Update Successfully", Toast.LENGTH_SHORT).show();
                }
            }

        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Update Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_gallery) {
            startActivity(new Intent(Userprofile.this,UserGallery.class));
            return true;
        }

        if (id == R.id.action_profile) {
            startActivity(new Intent(Userprofile.this,Userprofile.class));
            return true;
        }
*/
        if (id == R.id.action_logout) {
            startActivity(new Intent(Userprofile.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
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
