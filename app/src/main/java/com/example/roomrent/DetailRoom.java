package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailRoom extends AppCompatActivity {

    TextView DetailTitelRoom,nameRoom,floorRoom,buildingRoom,isReady;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);

        nameRoom = findViewById(R.id.nameRoom);
        floorRoom = findViewById(R.id.floorRoom);
        buildingRoom = findViewById(R.id.buildingRoom);
        isReady = findViewById(R.id.isReady);

        Rooms rooms = getIntent().getParcelableExtra("ROOM");
        nameRoom.setText(rooms.getName_room());
        floorRoom.setText(rooms.getFloor());
        buildingRoom.setText(rooms.getBuilding());
        isReady.setText(rooms.getIs_ready());
    }
}