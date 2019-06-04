package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.util.Log;

import com.example.applogin.DataAccess.Repositories.AccountRepository;

public class Account {

    private String accountNum;
    private long balance;
    private String state;
    private long userId;
    private Context context;


    private AccountRepository accountRepository;

    public Account(Context context, String account) {
        this.context = context;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
