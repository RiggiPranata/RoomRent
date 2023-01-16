package com.example.roomrent;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rooms implements Parcelable {
//    @SerializedName("room_id")
//    private int room_id;
    @SerializedName("room_name")
    private String room_name;
    @SerializedName("floor")
    private String floor;
    @SerializedName("building")
    private String building;
    @SerializedName("is_ready")
    private String is_ready;

    public Rooms(String room_name, String floor, String building, String is_ready) {
        this.room_name = room_name;
        this.floor = floor;
        this.building = building;
        this.is_ready = is_ready;
    }


    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getIs_ready() {
        return is_ready;
    }

    public void setIs_ready(String is_ready) {
        this.is_ready = is_ready;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.room_name);
        dest.writeString(this.floor);
        dest.writeString(this.building);
        dest.writeString(this.is_ready);
    }

    public void readFromParcel(Parcel source) {
        this.room_name = source.readString();
        this.floor = source.readString();
        this.building = source.readString();
        this.is_ready = source.readString();
    }

    protected Rooms(Parcel in) {
        this.room_name = in.readString();
        this.floor = in.readString();
        this.building = in.readString();
        this.is_ready = in.readString();
    }

    public static final Creator<Rooms> CREATOR = new Creator<Rooms>() {
        @Override
        public Rooms createFromParcel(Parcel source) {
            return new Rooms(source);
        }

        @Override
        public Rooms[] newArray(int size) {
            return new Rooms[size];
        }
    };
}

