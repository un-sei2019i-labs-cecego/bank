package com.example.applogin.DataAccess.Models;

import android.content.Context;

public class Account {

    private String accountNum;
    private long balance;
    private boolean state;
    private User user;

    private Context context;

    public Account(Context context){
        this.context = context;
    }

    public long getBalance(){
        return balance;
    }

    public String getAccountNum(){
        return accountNum;
    }

}
