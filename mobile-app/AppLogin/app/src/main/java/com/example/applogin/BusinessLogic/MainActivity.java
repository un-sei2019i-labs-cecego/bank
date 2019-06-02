package com.example.applogin.BusinessLogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applogin.DataAccess.Models.Person;
import com.example.applogin.DataAccess.Models.User;

import com.example.applogin.R;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;

    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = new Person(getApplicationContext());

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

            long id = Long.parseLong(editText1.getText().toString());
            long password = Long.parseLong(editText2.getText().toString());

            if (person.login(id, password)) {
                startActivity(new Intent(MainActivity.this, MyAccountActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }

        } catch(NumberFormatException ex){

            Toast.makeText(getApplicationContext(), "Los campos deben ser numéricos (y no vacios)", Toast.LENGTH_SHORT).show();

        }

    }

}
