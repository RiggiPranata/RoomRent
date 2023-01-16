package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailRoom extends AppCompatActivity {

    TextView nameRoom,floorRoom,buildingRoom,roomReady;
    String isReady;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);

        nameRoom = findViewById(R.id.nameRoom);
        floorRoom = findViewById(R.id.floorRoom);
        buildingRoom = findViewById(R.id.buildingRoom);
        roomReady =findViewById(R.id.roomReady);

        Rooms rooms = getIntent().getParcelableExtra("ROOM");
        nameRoom.setText(rooms.getRoom_name());
        floorRoom.setText(rooms.getFloor());
        buildingRoom.setText(rooms.getBuilding());
        String Ready = rooms.getIs_ready();
        if (Ready.equals("0")){
            isReady = "Available";
        }else if(Ready.equals("1")){
            isReady = "Booked";
        }
        roomReady.setText(isReady);
    }
}