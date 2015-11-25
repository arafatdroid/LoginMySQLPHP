package com.techacademy.loginmysqlphp;

/**
 * Created by priya on 7/16/2015.
 */
public class Contact {

    String name , email , username , password;

    public Contact(String name , String email , String username , String password)
    {
        this.name = name;
        this.email = email ;
        this.username = username;
        this.password = password;
    }

    public Contact(String username , String password)
    {
        this.username = username;
        this.password = password;
    }
}
