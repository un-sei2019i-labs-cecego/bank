package com.example.applogin.DataAccess.Models;

import android.content.Context;

public class Transaction {

    private User user1;
    private User user2;
    private String time;
    private String date;
    private String type;
    private long operatedBalance;
    private Context context;

    public Transaction (Context context){
        this.context = context;
    }

    public void madeTransaction(){

    }

}
