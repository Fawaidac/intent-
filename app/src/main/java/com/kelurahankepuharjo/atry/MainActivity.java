package com.kelurahankepuharjo.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    SharedPreferences prefs;
    UserSessions userSessions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userSessions = new UserSessions(MainActivity.this);
        if (userSessions.isUserLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish();
        }
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        username = findViewById(R.id.txusername);
        password = findViewById(R.id.txpw);
        login = findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().   toString();
                String pass = password.getText().   toString();
                if (name.equals("aku")&&pass.equals("123")){
                    userSessions.setUserLoggedIn(true);
                    userSessions.setUsername(name);
                    Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}