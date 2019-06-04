package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Repositories.TransactionRepository;
import com.example.applogin.DataAccess.Repositories.UserRepository;

public class User {


    private long id;
    private String name;
    private long phone;
    private String email;
    private String accountNumber;
    private int password;
    private Context context;

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    public User(Context context) {
        this.context = context;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
