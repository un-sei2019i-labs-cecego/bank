package com.example.applogin.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applogin.DataAccess.Usuario;

import com.example.applogin.R;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText2);
        editText2 = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                eventButton();
            }
        });

    }

    public void eventButton(){

        try {

            usuario = new Usuario(Integer.parseInt(editText1.getText().toString()), Integer.parseInt(editText2.getText().toString()));
            if (usuario.verficarContrasena(getApplicationContext())){
                Toast.makeText(getApplicationContext(), "Bienvenido papi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error papi", Toast.LENGTH_SHORT).show();
            }

        } catch(NumberFormatException ex){

            Toast.makeText(getApplicationContext(), "No lo haces bien papi", Toast.LENGTH_SHORT).show();

        }


    }

}
