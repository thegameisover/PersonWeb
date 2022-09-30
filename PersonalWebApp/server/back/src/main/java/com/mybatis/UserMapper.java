package com.mybatis;

public interface UserMapper {
    public String login(String account,String password);
    public void logup(String name, String account, String password);
    public String exist(String account);
    public String UserName(String account,String password);

    public String Getname(String name);
}
