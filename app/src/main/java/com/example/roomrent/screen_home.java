package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class screen_home extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home);

        sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

    }


    public void goToRoom(View view) {
        startActivity(new Intent(this, Room.class));
    }

    public void goToRent(View view) {
        startActivity(new Intent(this, peminjaman.class));
    }
    public void goToProfile(View view) {
        startActivity(new Intent(this, profile.class));
    }


    public void goToLogOut(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Login.KEY_USER);
        editor.apply();
        finish();
        startActivity(new Intent(this, Login.class));
    }
}