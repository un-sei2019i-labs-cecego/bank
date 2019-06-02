package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class User extends Person{

    private long password;
    private Account account;

    public User(Context context, long id) {
        super(context);
    }

    public String getAccountNum(){
        return account.getAccountNum();
    }

    public long getBalance(){
        return account.getBalance();
    }

    public String[][] getTransactionHistory(){
        return null;
    }

    public boolean transferBalance(){
        return false;
    }

    public boolean changePassword(){
        return false;
    }

}
