package com.example.roomrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

@SuppressWarnings("ALL")
public class Dashboard extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        replaceFragment(new HomeFragment());
        bottomNav = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.divFragment, new HomeFragment()).commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;


                switch (menuItem.getItemId()) {
                    case R.id.home:
                        //aksi ketika home di klik
                        //                tulisan.setText("Tombol home diklik")
                        selectedFragment = new HomeFragment();
                        Log.d("home_nav", "success move to home screen");
                        break;
                    case R.id.rent:
                        //aksi ketika profile di klik
                        //                tulisan.setText("Tombol rent diklik");
                        selectedFragment = new peminjaman();
                        Log.d("rent_nav", "success move to rent screen");
                        break;
                    case R.id.history:
                        //aksi ketika folder di klik
                        //                tulisan.setText("Tombol history diklik");
                        selectedFragment = new HistoryFragment();
                        Log.d("rent_nav", "success move to history screen");
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.divFragment, selectedFragment).commit();
                return true;
            }
        });


    }
        private void replaceFragment(HomeFragment homeFragment) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.divFragment,homeFragment);
            fragmentTransaction.commit();
        }

    }


