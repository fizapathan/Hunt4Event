package com.example.AndroidStudioProjects.FinalProject;

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

import com.example.nitika.FinalProject.R;

/**
 * Created by fiza on 18-Mar-18.
 */

public class GalleryAdapter extends ArrayAdapter {
    public GalleryAdapter(@NonNull Context context, int resource) {
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
            row=layoutInflater.inflate(R.layout.activity_rowgallery,parent,false);
            contactholder =new Contactholder();
            contactholder.tx_gname=(TextView)row.findViewById(R.id.rtx2);
            contactholder.tx_gimage=(ImageView)row.findViewById(R.id.riv2);

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