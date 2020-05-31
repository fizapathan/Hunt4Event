package com.example.AndroidStudioProjects.FinalProject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by nitika on 14-Mar-18.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by fiza on 14-Mar-18.
 */

public class myclass extends SQLiteOpenHelper {
    public myclass(Context context) {
        super(context, "event.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table admin(aid INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),email varchar(30),password varchar(20))");
        db.execSQL("insert into admin(name,email,password)VALUES('Admin','admin@gmail.com','123456789')");
        db.execSQL("create table eventhandler(eid INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),email varchar(30),password varchar(20))");
        db.execSQL("create table user(uid INTEGER PRIMARY KEY AUTOINCREMENT,uname varchar(20),email varchar(30),password varchar(15))");
        db.execSQL("create table area(aaid INTEGER PRIMARY KEY AUTOINCREMENT,areaname varchar(20) )");//line no 297 for addarea, update at 402
        db.execSQL("create table category(cid INTEGER PRIMARY KEY AUTOINCREMENT,ecatname varchar(20))");
        db.execSQL("create table event(etid INTEGER PRIMARY KEY AUTOINCREMENT,eventname varchar(20),eventdescription varchar(100),aaid INTEGER,eid INTEGER,cid INTEGER,eventdate varchar(30),price varchar(15),eimage BLOB)");
        db.execSQL("create table subcategory(sbctid INTEGER PRIMARY KEY AUTOINCREMENT,subcatname varchar(20),cid INTEGER)");
        db.execSQL("create table gallery(gid INTEGER PRIMARY KEY AUTOINCREMENT,gname varchar(20),gimage BLOB,eid INTEGER,uid INTEGER)");  //near 580
        db.execSQL("create table booking(bid INTEGER PRIMARY KEY AUTOINCREMENT,boption varchar(30),etid INTEGER,eid INTEGER,uid INTEGER)");
        db.execSQL("create table book_order(bid INTEGER PRIMARY KEY AUTOINCREMENT,uid ineteger,eid integer,amount integer,mode VARCHAR(10)) ");
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor fetchuser(String uid)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return  db.rawQuery("select * from user where uid="+uid,null);

    }

    //activity_Userprofile and java file is Userprofile.java
    public boolean updateuser(String id,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uname",name);
        long res=db.update("user",contentValues,"uid"+"=?",new String[]{id});
        if(res>0)
        {
            return true;
        }
        return false;

    }
    //getuserid

    public String getMyUId(String email)
    {

        String e="";
        Cursor c = loginuserId(email);
        if(c.getCount()>0)
        {
            int id = c.getColumnIndex("uid");
            while(c.moveToNext())
            {
                e=c.getString(id);

            }
        }
        return e;
    }
    public String getMyUnameId(String email)
    {

        String e="";
        Cursor c = loginuserId(email);
        if(c.getCount()>0)
        {
            int id = c.getColumnIndex("uname");
            while(c.moveToNext())
            {
                e=c.getString(id);

            }
        }
        return e;
    }

    public Cursor loginuserId(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user where email='"+email+"'",null);
    }


    //getehid

    public String getMyEhId(String email)
    {

        String e="";
        Cursor c = loginehId(email);
        if(c.getCount()>0)
        {
            int id = c.getColumnIndex("eid");
            while(c.moveToNext())
            {
                e=c.getString(id);

            }
        }
        return e;
    }

    public Cursor loginehId(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from eventhandler where email='"+email+"'",null);
    }

    //admin login
    public Cursor loginadmin(String email, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from admin where email='"+email+"' and password='"+password+"'",null);
    }
    // select cat
    public Cursor selectcat(String ecatname)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from category where ecatname='"+ecatname+"'",null);
    }

    public Cursor fpassword(String q)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery(q,null);

    }
    public boolean addbook(String uid,String eid,String amount,String mode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uid",uid);
        contentValues.put("eid",eid);
        contentValues.put("amount",amount);
        contentValues.put("mode",mode);

        long res=db.insert("book_order",null,contentValues);

        if(res>0)
        {
            return true;
        }
        return false;
    }
    public Cursor showsbook(String q)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery(q,null);
    }


    //insert user

    public boolean addeh(String name,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("email",email);

        c.put("password",password);

        long res=db.insert("eventhandler",null,c);

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //insert bookdetail

    public boolean book(int bid,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("bid",bid);
        long res=db.insert("booking",null,c);

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //insert user

    public boolean adduser(String uname,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("uname",uname);
        c.put("email",email);

        c.put("password",password);

        long res=db.insert("user",null,c);

        if(res>0)
        {
            return true;
        }
        return false;
        //String q="insert into user(name,email,contact,password)values('"+name+"','"+email+"','"+contact+"','"+password+"')";
    }

    //insert user

    public boolean addevent(String evname,String evdescp,String evedate,String eveprice,byte[] eimage)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("eventname",evname);
        c.put("eventdescription",evdescp);
        c.put("eventdate",evedate);
        c.put("price",eveprice);
        c.put("eimage",eimage);

        long res=db.insert("event",null,c);

        if(res>0)
        {
            return true;
        }
        return false;

    }
    // add cat
    public boolean addcat(String catname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("ecatname",catname);

        long res=db.insert("category",null,c);

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //addsubcat
    public boolean subactadd(int cid, String subcatname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("cid",cid);
        c.put("subcatname",subcatname);

        long res=db.insert("subcategory",null,c);

        if(res>0)
        {
            return true;
        }
        return false;
    }

    // addarea
    public boolean addarea(String areaname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("areaname",areaname);

        long res=db.insert("area",null,c);

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //eh login

    public Cursor logineh(String email, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from eventhandler where email='"+email+"' and password='"+password+"'",null);
    }
    // user login
    public Cursor loginuser(String email, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user where email='"+email+"' and password='"+password+"'",null);
    }

    // userside2
    public Cursor getevent(String m)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from event where etid="+m,null);
    }
    //showuser
    public Cursor showuser()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user",null);
    }

    //showcatinusr
    public Cursor showcatinusr()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from category ",null);
    }

    //showcatinusr
    public Cursor showgalleryinusr()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from gallery ",null);
    }
    //getarea

    /*  public Cursor getarea(String aaid)
      {
          SQLiteDatabase db=this.getReadableDatabase();
          return db.rawQuery("select * from area where aaid='"+aaid+"'",null);
      }*/
    //showuser
    public Cursor showarea()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from area",null);
    }

    //showuserineh
    public Cursor showuserineh()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user",null);
    }

    //showcat
    public Cursor catgshow()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from category ",null);
    }

    public Cursor subcatshow()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from subcategory ",null);
    }


    public Cursor ehshow()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from eventhandler ",null);
    }

    //showyourevent
    public Cursor showeve()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return  db.rawQuery("select *from event",null);
    }
    //updateuser

    public boolean updatearea(int id,String areaname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("areaname",areaname);

        long res=db.update("area",contentValues,"aaid"+"=?",new String[]{String.valueOf(id)});

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //deletearea

    public boolean deletearea(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("area","aaid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }

    //updateeventname

    public boolean updatevename(int id,String eventname,String eventdes,String evedate,String eveprice)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("eventname",eventname);
        contentValues.put("eventdescription",eventdes);
        contentValues.put("eventdate",evedate);
        contentValues.put("price",eveprice);

        long res=db.update("event",contentValues,"etid"+"=?",new String[]{String.valueOf(id)});

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //deleteeventname

    public boolean deleteevename(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("event","etid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }

    //getarea
    public Cursor getarea(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from area where aaid="+id,null);
    }

    //getuser
    public Cursor getuser(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user where uid="+id,null);
    }

    //getuserineh
    public Cursor getuserineh(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from user where uid="+id,null);
    }

    //getsubcat
    public Cursor getsubcat(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from subcategory where cid="+id,null);
    }

    //geteh
    public Cursor geteh(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("select * from eventhandler where eid="+id,null);
    }
    //updatecat

    public boolean updatecatname(int id,String ecatname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ecatname",ecatname);



        long res=db.update("category",contentValues,"cid"+"=?",new String[]{String.valueOf(id)});

        if(res>0)
        {
            return true;
        }
        return false;

    }

    //deletecatname

    public boolean deletecatname(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("category","cid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }

    //deleteusername

    public boolean deleteusername(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("user","uid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }

    //deleteusernameineh

    public boolean deleteusernameineh(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("user","uid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }


    //deleteehname

    public boolean deleteehname(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.delete("eventhandler","eid"+"=?",new String[]{String.valueOf(id)});
        if(res>0)
        {
            return true;
        }
        return false;

    }

    //addgallery
    public  void addgallery(String gname,byte[] gimage)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String q="insert into gallery values(NULL,?,?,?,?)";

        SQLiteStatement statement=db.compileStatement(q);
        statement.clearBindings();
        statement.bindString(1,gname);
        statement.bindBlob(2,gimage);
        statement.executeInsert();

    }

    //showgallery

    public Cursor showgallery()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return  db.rawQuery("select * from gallery",null);
    }


    //addsubcat
    public boolean addsubcat(String subcatname) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("subcatname",subcatname);
        // c.put("cid",cid);

        long res=db.insert("subcategory",null,c);

        if(res>0)
        {
            return true;
        }
        return false;
    }

    public Cursor paytm()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return  db.rawQuery("select * from booking",null);
    }
}
