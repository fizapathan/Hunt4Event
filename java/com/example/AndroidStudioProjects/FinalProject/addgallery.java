package com.example.AndroidStudioProjects.FinalProject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.AndroidStudioProjects.FinalProject.Showgallery;
import com.example.AndroidStudioProjects.FinalProject.myclass;
import com.example.nitika.FinalProject.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class addgallery extends AppCompatActivity {
    EditText gt1;
    Button bg1,bg2;
    ImageView gi1;
    myclass obj;
    int REQUEST_CODE_GALLERY=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgallery);
        startconf();
        obj=new myclass(this);

        bg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);

            }
        });

        bg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gname= gt1.getText().toString();
                try
                {
                    obj.addgallery(gname,imageviewtobyte(gi1));
                    showmsg("Gallery added");
                    startActivity(new Intent(addgallery.this,Showgallery.class));
                }
                catch(Exception ex)
                {
                    showmsg("Unable to Add Image to Gallery");
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_GALLERY && resultCode==RESULT_OK && data!=null);
        {
            try {
                Uri uri = data.getData();
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                gi1.setImageBitmap(bitmap);
                showmsg("Image display");
            }
            catch (Exception ex)
            {
                showmsg("Unable to Add Image");
            }
        }
    }

    //imageview to byteform
    public byte[] imageviewtobyte(ImageView imageView)
    {
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] sarray=stream.toByteArray();
        return sarray;
    }

    public void startconf()
    {
        gt1=findViewById(R.id.ged1);
        bg1=findViewById(R.id.gb1);
        bg2=findViewById(R.id.gb2);
        gi1=findViewById(R.id.giv2);
    }
    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void show(View view)
    {
        startActivity(new Intent(addgallery.this,Showgallery.class));
    }
}
