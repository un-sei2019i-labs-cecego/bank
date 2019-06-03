package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Repositories.UserRepository;

public class User extends Person{

    private long password;
    private Account account;

    private Context context;

    private UserRepository userRepository;

    public User(Context context, long id) {
        super(context);

        userRepository = new UserRepository(context);
        Object[] results  = userRepository.getUserById(id);

        this.id = (long) results[0];
        this.name = (String) results[1];
        this.phone = (long) results[2];
        this.email = (String) results[3];
        this.account = new Account(context, (String) results[4]);
        this.password = (long) results[5];

    }

    public long getPsssowrd(){
        return password;
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
