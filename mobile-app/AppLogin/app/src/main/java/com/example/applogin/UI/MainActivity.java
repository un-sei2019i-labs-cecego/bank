package com.example.applogin.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.applogin.DataAccess.Usuario;

import com.example.applogin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario u = new Usuario(1022419092, 123456);

        Log.d("Resultado", String.valueOf(u.verficarContrasena(this)));

    }
}
