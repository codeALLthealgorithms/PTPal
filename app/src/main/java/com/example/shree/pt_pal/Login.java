package com.example.shree.pt_pal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Login extends AppCompatActivity
{

    private EditText Name;
    private EditText Password;
    private Button Login;

    PTPalDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDB = new PTPalDB(this);

        Name = (EditText)findViewById(R.id.userUsername);
        Password = (EditText)findViewById(R.id.userPassword);
        Login = (Button) findViewById(R.id.loginButton);

        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userUsername, String userPassword)
    {
        if((userUsername.equals("admin")) && (userPassword.equals("test")))
        {
            Intent intent = new Intent(Login.this, Exercises.class);
            startActivity(intent);
        }

    }
}
