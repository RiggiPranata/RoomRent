package com.example.roomrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressWarnings("ALL")
public class Dashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNav;
    private TextView tulisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNav = findViewById(R.id.bottomNav);
        tulisan = findViewById(R.id.tulisan);
        bottomNav.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                //aksi ketika home di klik
                tulisan.setText("Tombol home diklik");
                Log.d("home_nav","success move to home screen");
                break;
            case R.id.rent:
                //aksi ketika profile di klik
                tulisan.setText("Tombol rent diklik");
                Log.d("rent_nav","success move to rent screen");
                break;
            case R.id.history:
                //aksi ketika folder di klik
                tulisan.setText("Tombol history diklik");
                Log.d("rent_nav","success move to history screen");
                break;
        }
        return true;
    }


}