package com.rguz.activities2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginEmail ;
    EditText loginPass ;
    Button loginBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn  = findViewById(R.id.buttonLogin);
        loginEmail =  findViewById(R.id.editTextEmail);
        loginPass  =  findViewById(R.id.editTextPassword);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = loginEmail.getText().toString().toLowerCase();

                if (!validate())   {

                Intent sendEmail = new Intent(MainActivity.this, SelectEmployee.class);
                sendEmail.putExtra("Send_Email", text);
                startActivity(sendEmail);
                }

              }

        });

    }

    private boolean validate() {
        if (loginEmail.getText().toString().trim().length()<=0) {
            Toast.makeText(MainActivity.this,"Please enter a valid username", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (loginPass.getText().toString().trim().length()<=0) {
            Toast.makeText(MainActivity.this,"Please enter a valid Password", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;

    }

}

