package com.example.applogin.DataAccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class Usuario {

    long identificacion;
    long contrasena;

    public Usuario(long identificacion, long contrasena){

        this.identificacion = identificacion;
        this.contrasena = contrasena;

    }

    public boolean verficarContrasena(Context context) {

        Sqlite sqlite = new Sqlite(context);
        SQLiteDatabase bd = sqlite.getWritableDatabase();
        Cursor fila = bd.rawQuery("select identificacion, claveNumerica from usuario where identificacion = " + identificacion + " and claveNumerica = " + contrasena, null);

        if (fila.moveToFirst()) {

            if (fila.getInt(0) == identificacion && fila.getInt(1) == contrasena) {

                bd.close();
                return true;

            }

        }

        bd.close();
        return false;

    }

}
