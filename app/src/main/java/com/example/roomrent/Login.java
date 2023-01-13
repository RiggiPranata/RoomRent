package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText EmailLogin, PasswordLogin;
    SharedPreferences sharedPref;
    static String KEY_USER = "email_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailLogin = findViewById(R.id.txtEmailLogin);
        PasswordLogin = findViewById(R.id.txtPasswordLogin);
        sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

    }

    public void login(View v){
        String emailUser = EmailLogin.getText().toString();

        startActivity(new Intent(this, Dashboard.class));
    }

    public void registration(View view) {
        startActivity(new Intent(this, Registration.class));
    }
}