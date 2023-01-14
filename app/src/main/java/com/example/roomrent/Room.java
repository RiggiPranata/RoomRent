package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Room extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    ArrayList<Rooms> listData = new ArrayList<Rooms>();
    Inflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

//        recyclerView = findViewById(R.id.rvFragHome);
//
//        for(int i=0;i<10;i++){
//            listData.add(new Rooms("Kelas"+i,""+i,"Gedung"+i,0));
//        }
//
//        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        adapterData = new AdapterData(this,listData);
//        recyclerView.setAdapter(adapterData);
//        adapterData.notifyDataSetChanged();


    }

}