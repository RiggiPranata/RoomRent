package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View v) {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }
   public void signUp(View v){
    Intent intent = new Intent(MainActivity.this, screen_home.class);
    startActivity(intent);
   }

}