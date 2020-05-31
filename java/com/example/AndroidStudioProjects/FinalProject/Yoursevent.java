package com.example.AndroidStudioProjects.FinalProject;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Yoursevent extends AppCompatActivity {
    EditText evb1,evb2,evb3,evb4;
    Button evbtn1,evbtn2,edbn1;
    ImageView edimg2;

    myclass obj;
    int REQUEST_CODE_GALLERY=999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoursevent);
        obj=new myclass(this);
        startconf();

        edbn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);

            }
        });

        evbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eventname=evb1.getText().toString();
                String eventdescription= evb2.getText().toString();
                String   eventdate=evb3.getText().toString();
                String price=evb4.getText().toString();
                //String image=edbn1.getText().toString();


                if(!isValideventname(eventname))
                {
                    evb1.setError("Name can't be empty ");
                }
                if(!isValideventdescription(eventdescription))
                {
                    evb2.setError("Name can't be empty ");
                }
                if(!isValideventdate(eventdate))
                {
                    evb3.setError("Name can't be empty ");
                }
                if(!isValidprice(price))
                {
                    evb4.setError("Name can't be empty ");
                }

                try
                {


                    if(obj.addevent(eventname,eventdescription,eventdate,price,imageviewtobyte(edimg2)))
                    {
                        showmsg("Details added successfully.");
                    }
                    else {
                        showmsg("Details not added properly.");
                    }

                }
                catch (Exception ex)
                {
                    ex.getMessage();
                }
            }
        });
        evbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Yoursevent.this,showyourevents.class));
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
                edimg2.setImageBitmap(bitmap);
                showmsg("Image display");
            }
            catch (Exception ex)
            {
                showmsg(ex.getMessage());
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
        evb1=findViewById(R.id.etev1);
        evb2=findViewById(R.id.etev2);
        evb3=findViewById(R.id.etev3);
        evb4=findViewById(R.id.etev4);
        evbtn1=findViewById(R.id.eb1);
        evbtn2=findViewById(R.id.eb2);
        edbn1=findViewById(R.id.edbtn1);
    }

    public void showmsg(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    private  boolean isValideventname(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
    private  boolean isValideventdescription(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
    private  boolean isValideventdate(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }
    private  boolean isValidprice(String n)
    {
        if(n!=null&&n.length()>0)
        {
            return  true;
        }
        return  false;
    }

}
