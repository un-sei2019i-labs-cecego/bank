package com.example.applogin.BusinessLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.example.applogin.DataAccess.Models.User;
import com.example.applogin.R;

public class MyAccountActivity extends AppCompatActivity {

    Button button;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        // Llamar TabHost
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);

        // Preparar TabHost para confguracion
        tabs.setup();

        // Crear las pestañas
        TabHost.TabSpec spec1 = tabs.newTabSpec("mitab1");
        TabHost.TabSpec spec2 = tabs.newTabSpec("mitab2");

        // Asignar contenido a cada pestaña
        spec1.setContent(R.id.Cuenta);
        spec2.setContent(R.id.Transacciones);

        // Asignar icono u texto a cada pestaña
        spec1.setIndicator("Mi cuenta");
        spec2.setIndicator("Transacciones");

        // Anadir pestañas al TabHost
        tabs.addTab(spec1);
        tabs.addTab(spec2);

        // Definir posicion pestaña actual
        tabs.setCurrentTab(0);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                eventButton();
            }
        });

    }

    public void eventButton(){


    }

}
