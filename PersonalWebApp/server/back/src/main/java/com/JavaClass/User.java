package com.JavaClass;

public class User {
    private String account=null;
    private String password=null;
    private String userName=null;
    private String verificationCode=null;


    public User()
    {

    }

    public User(String account,String password,String userName,String verificationCode)
    {
        this.account=account;
        this.password=password;
        this.userName=userName;
        this.verificationCode=verificationCode;
    }


    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    @Override
    public String toString() {
        return account+" "+password+" "+userName+" "+verificationCode+" ";
    }
}
