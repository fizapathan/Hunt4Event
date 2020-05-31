package com.example.AndroidStudioProjects.FinalProject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.finalproject.MainPage;
import com.example.nitika.FinalProject.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class login extends AppCompatActivity {
  EditText et1,et2;
  TextView t1;
  Button b1,b2;
   myclass obj;

    SharedPreferences sharedPreferences;

    public static final String Mypreferences="MyLogin";
    public  static final String UserID="userkey";
    public  static final String UserName="usernamekey";
    public  static final String EhID="ehkey";


    /*
    public void main_page(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if(button_text.equals("login"))
        {
            Intent intent1 = new Intent(login.this,MainPage.class);
           // startActivity(intent1);
        }
       else if(button_text.equals("signup"))
        {
            Intent intent2 = new Intent(login.this,MainPage.class);
            startActivity(intent2);
        }
    }
    //flag = 1;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        obj = new myclass(this);
        startconf();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et1.getText().toString();
                String password = et2.getText().toString();


                Cursor c = obj.loginuser(email, password);

                if (!isValidEmail(email))
                {
                    et1.setError("Invalid Email");
                }
                if(!isValidPassword(password))
                {
                    et2.setError("Password is too small ");
                }


                try {

                    if (c.getCount() > 0) {
                        sharedPreferences=getSharedPreferences(Mypreferences, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(UserID,obj.getMyUId(email));
                        editor.putString(UserName,obj.getMyUnameId(email));
                        editor.commit();
                        showmsg("Login Successfully");
                        String button_text;
                        button_text = ((Button) view).getText().toString();
                        if(button_text.equals("login")) {
                            Intent intent1 = new Intent(login.this, MainPage.class);
                            startActivity(intent1);
                        }
                    } else {
                        Cursor c1 = obj.logineh(email, password);
                        if (c1.getCount() > 0) {
                            sharedPreferences=getSharedPreferences(Mypreferences, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(EhID,obj.getMyEhId(email));
                            editor.commit();
                            showmsg("Event handler login successfully");
                            startActivity(new Intent(login.this,Ehinneract.class));

                        } else {
                            Cursor c2 = obj.loginadmin(email, password);
                            if (c2.getCount() > 0) {
                                showmsg("Admin login");
                                startActivity(new Intent(login.this, adminact.class));
                            } else {
                                showmsg("Invalid Email or Password");
                            }
                        }
                    }

                } catch (Exception ex) {
                    showmsg("Login Failed");
                }


             /*   if (flag == 1) {

                    b1 = (Button) findViewById(R.id.b1);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            main_page();
                        }
                    });

                     public void main_page() {
                Intent intent = new Intent(login.this,MainPage.class);
                startActivity(intent);
            }

                }*/
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,ehuser.class));

            }
        });
    }

    public void startconf()
    {
        et1= (EditText)findViewById(R.id.ed1);
        et2= (EditText)findViewById(R.id.ed2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        t1=(TextView)findViewById(R.id.textView2);
    }

    public  void fpassword(View view)
    {
        startActivity(new Intent(login.this,Forgotpassword.class));
    }
    public void showmsg(String msg)
    {
        Toast.makeText(login.this, msg, Toast.LENGTH_SHORT).show();
    }

    private boolean isValidEmail(String em)
    {
        String epattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern= Pattern.compile(epattern);
        Matcher matcher=pattern.matcher(em);
        return  matcher.matches();
    }

    private boolean isValidPassword(String p)
    {
        if(p!=null&&p.length()>6)
        {
            return  true;
        }
        return  false;
    }


}
