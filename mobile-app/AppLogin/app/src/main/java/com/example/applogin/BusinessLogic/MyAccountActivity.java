package com.example.applogin.BusinessLogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import com.example.applogin.DataAccess.Models.User;
import com.example.applogin.DataAccess.Repositories.TransactionRepository;
import com.example.applogin.R;

public class MyAccountActivity extends AppCompatActivity {

    Button button;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    EditText editText1;
    EditText editText2;
    EditText editText3;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        // Llamar elementos graficos
        button = (Button) findViewById(R.id.button);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        // Llamar datos del usuario
        user = new User(getApplicationContext(), getIntent().getLongExtra("id", 0));

        NumberFormat formatter = new DecimalFormat("#,###");
        double myNumber = 1000000;
        String formattedNumber = formatter.format(user.getBalance());

        // Asignar datos del usuario
        textView1.setText(user.getName());
        textView2.setText("C.C. " + user.getId() + "");
        textView3.setText("Cuenta No. " + user.getAccountNum());
        textView4.setText("$" + formattedNumber + "");

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

        // Crear evento para hacer transacción
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                eventButton();
            }
        });

    }

    // realizar transacción
    public void eventButton() {

        try {

            String account = editText1.getText().toString();
            long money = Long.parseLong(editText2.getText().toString());
            long password = Long.parseLong(editText3.getText().toString());
            NumberFormat formatter = new DecimalFormat("#,###");
            String formattedNumber = formatter.format(user.getBalance());

            if (password == user.getPassowrd() && user.transferBalance(account,money)){

                textView4.setText("$" + formattedNumber + "");
                Toast.makeText(getApplicationContext(), "Transacción realizada", Toast.LENGTH_SHORT).show();

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");

                // Llamar datos del usuario
                user = new User(getApplicationContext(), getIntent().getLongExtra("id", 0));

                formatter = new DecimalFormat("#,###");
                double myNumber = 1000000;
                formattedNumber = formatter.format(user.getBalance());

                // Asignar datos del usuario
                textView1.setText(user.getName());
                textView2.setText("C.C. " + user.getId() + "");
                textView3.setText("Cuenta No. " + user.getAccountNum());
                textView4.setText("$" + formattedNumber + "");

            }  else {
                Toast.makeText(getApplicationContext(), "La transacción no se pudo realizar", Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException ex) {

            Toast.makeText(getApplicationContext(), "Los campos de saldo y contraseña deben ser numéricos (y no vacios)", Toast.LENGTH_SHORT).show();

        }

    }

}
