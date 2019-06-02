package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class Person {

    protected long id;
    protected String name;
    protected long phone;
    protected String email;

    private Context context;

    public Person(Context context) {
        this.context = context;
    }

    public boolean login(long id, long password) {

        DataBase sqlite = new DataBase(context);
        SQLiteDatabase bd = sqlite.getWritableDatabase();
        Cursor fila = bd.rawQuery("select identificacion, claveNumerica from usuario where identificacion = " + id + " and claveNumerica = " + password, null);

        if (fila.moveToFirst()) {

            if (fila.getInt(0) == id && fila.getLong(1) == password) {

                bd.close();
                return true;

            }

        }

        bd.close();
        return false;

    }

    public void restorePassword() {

    }

}
