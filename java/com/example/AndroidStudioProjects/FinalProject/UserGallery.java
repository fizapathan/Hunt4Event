package com.example.AndroidStudioProjects.FinalProject;

/**
 * Created by Nazim Patham on 24-03-2018.
 */
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class UserGallery extends AppCompatActivity {

    GridView gal1;
    ArrayList<String> gl1;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_gallery);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gal1=(GridView)findViewById(R.id.uid1);
        gl1=new ArrayList<String>();
        obj=new myclass(this);
        UserGalleryAdapter userGalleryAdapter;
        userGalleryAdapter=new UserGalleryAdapter(UserGallery.this,R.layout.urow_gallery);

        Cursor c=obj.showgallery();
        try
        {
            while (c.moveToNext())
            {
                int gid=c.getInt(0);
                String gname=c.getString(1);
                byte[] giamge=c.getBlob(2);

                GalleryClass galleryClass=new GalleryClass(gid,gname,giamge);

                userGalleryAdapter.add(galleryClass);
                gal1.setAdapter(userGalleryAdapter);
            }
        }
        catch (Exception ex)
        {
            //ex.getMessage();
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
       /* if (id == R.id.action_gallery) {
            startActivity(new Intent(UserGallery.this,UserGallery.class));
            return true;
        }
*/
        if (id == R.id.action_profile) {
            startActivity(new Intent(UserGallery.this,Userprofile.class));
            return true;
        }

        if (id == R.id.action_logout) {
            startActivity(new Intent(UserGallery.this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
