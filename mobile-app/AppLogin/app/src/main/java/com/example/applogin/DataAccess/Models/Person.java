package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Repositories.UserRepository;

public class Person {

    protected long id;
    protected String name;
    protected long phone;
    protected String email;

    private Context context;

    private UserRepository userRepository;

    public Person(Context context) {
        this.context = context;
        userRepository = new UserRepository(context);
    }

    public boolean login(long id, long password) {

        if (userRepository.getUserById(id)[5] != null && (long) userRepository.getUserById(id)[5] == password){
            return true;
        }
        return false;

    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void restorePassword() {

    }

}
