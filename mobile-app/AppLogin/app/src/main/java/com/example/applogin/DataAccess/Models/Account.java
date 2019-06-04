package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.util.Log;

import com.example.applogin.DataAccess.Repositories.AccountRepository;

public class Account {

    private String accountNum;
    private long balance;
    private String state;

    private Context context;

    private AccountRepository accountRepository;

    public Account(Context context, String account){
        this.context = context;

        accountRepository = new AccountRepository(context);
        Object[] results  = accountRepository.getAccountById(account);
        this.accountNum = (String) results[0];
        this.balance = (long) results[1];
        this.state = (String) results[2];

    }

    public long getBalance(){
        return balance;
    }

    public String getAccountNum(){
        return accountNum;
    }

}
