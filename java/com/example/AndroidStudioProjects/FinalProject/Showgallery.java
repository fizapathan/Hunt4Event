package com.example.AndroidStudioProjects.FinalProject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.GalleryAdapter;
import com.example.AndroidStudioProjects.FinalProject.GalleryClass;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.util.ArrayList;

public class Showgallery extends AppCompatActivity {
    ListView gal1;
    ArrayList<String> gl1;
    myclass obj;

    GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showgallery);
        gal1=(ListView)findViewById(R.id.shls1);
        gl1=new ArrayList<String>();
        obj=new myclass(this);

        galleryAdapter=new GalleryAdapter(Showgallery.this,R.layout.activity_rowgallery);

        Cursor c=obj.showgallery();
        try
        {
            while (c.moveToNext())
            {
                int gid=c.getInt(0);//i is string showing column name
                String gname=c.getString(1);
                byte[] giamge=c.getBlob(2);//returns result of SQL query

                GalleryClass galleryClass=new GalleryClass(gid,gname,giamge);

                galleryAdapter.add(galleryClass);
                gal1.setAdapter(galleryAdapter);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Please add an image", Toast.LENGTH_SHORT).show();        }
    }

    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
