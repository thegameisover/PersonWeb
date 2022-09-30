package com.mybatis;

public interface BGMapper {
    public void SetBG(String name,String address);

    public String GetBG(String name);

    public void AlertBG(String name,String address);

    public String GetPicture(String name);
}
