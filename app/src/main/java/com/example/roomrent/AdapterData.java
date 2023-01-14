package com.example.roomrent;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    ArrayList<Rooms> arrayListRoom;
    LayoutInflater inflater;

    public AdapterData(Context context, ArrayList<Rooms> arrayListRoom) {
        this.arrayListRoom = arrayListRoom;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        final Rooms rooms = arrayListRoom.get(position);

        holder.nameRoom.setText(rooms.getName_room());
        holder.floorRoom.setText(rooms.getFloor());
        holder.buildRoom.setText(rooms.getBuilding());
        holder.isReady.setText(rooms.getIs_ready());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailRoom.class);
                intent.putExtra("ROOM" , rooms);
                holder.itemView.getContext().startActivity(intent);
            }
        });

//        holder.imageRoom.setImageDrawable(Drawable.createFromPath(listData.get(position)));

    }

    @Override
    public int getItemCount() {
        return arrayListRoom.size();
    }


    public class HolderData extends RecyclerView.ViewHolder {

        TextView nameRoom,floorRoom,buildRoom,isReady;
        ImageView imageRoom;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            nameRoom = itemView.findViewById(R.id.nameRoom);
            floorRoom = itemView.findViewById(R.id.floorRoom);
            buildRoom = itemView.findViewById(R.id.buildingRoom);
            isReady = itemView.findViewById(R.id.isReady);
//            imageRoom = itemView.findViewById(R.id.imageRoom);
        }
    }
}
