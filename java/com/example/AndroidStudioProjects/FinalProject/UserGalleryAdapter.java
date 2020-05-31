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
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nitika on 23-Mar-18.
 */

public class UserGalleryAdapter  extends ArrayAdapter{
    public UserGalleryAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        Contactholder contactholder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.urow_gallery,parent,false);
            contactholder =new Contactholder();
            contactholder.tx_gname=(TextView)row.findViewById(R.id.urt1);
            contactholder.tx_gimage=(ImageView)row.findViewById(R.id.urimage1);

            ViewGroup.LayoutParams layoutParams=contactholder.tx_gimage.getLayoutParams();

            layoutParams.height=400;
            layoutParams.width=400;
            contactholder.tx_gimage.setLayoutParams(layoutParams);
            row.setTag(contactholder);
        }
        else
        {
            contactholder=(Contactholder)row.getTag();
        }
        GalleryClass galleryClass=(GalleryClass) this.getItem(position);

        contactholder.tx_gname.setText(galleryClass.getGname());

        byte[] gimage=galleryClass.getGimage();

        Bitmap bitmap= BitmapFactory.decodeByteArray(gimage,0,gimage.length);

        contactholder.tx_gimage.setImageBitmap(bitmap);

        return row;

    }
    public class Contactholder
    {
        TextView tx_gname;
        ImageView tx_gimage;
    }
}
