package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class User extends Person{

    private long password;
    private Account account;

    public User(Context context, long id) {
        super(context, id);
    }


    public String getAccountNum(){
        return account.getAccountNum();
    }

    /*public boolean verficarContrasena(Context context) {

        DataBase sqlite = new DataBase(context);
        SQLiteDatabase bd = sqlite.getWritableDatabase();
        Cursor fila = bd.rawQuery("select id, password from user where id = " + identificacion + " and password = " + contrasena, null);

        if (fila.moveToFirst()) {

            if (fila.getInt(0) == identificacion && fila.getInt(1) == contrasena) {

                bd.close();
                return true;*/

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
