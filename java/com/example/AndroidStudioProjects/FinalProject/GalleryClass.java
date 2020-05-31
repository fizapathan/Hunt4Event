package com.example.AndroidStudioProjects.FinalProject;

public class GalleryClass  {
    int id;
    String gname;
    byte[] gimage;

    GalleryClass(int gid,String gname,byte[] gimage)
    {
        this.id=gid;
        this.gname=gname;
        this.gimage=gimage;
    }
    public int getId()
    {
        return id;
    }
    public void setId()
    {
        this.id=id;
    }
    public String getGname()
    {
        return gname;
    }
    public void setGname()
    {
        this.gname=gname;
    }
    public byte[] getGimage()
    {
        return gimage;
    }
    public void setGimage(byte[] gimage)
    {
        this.gimage=gimage;
    }
}
