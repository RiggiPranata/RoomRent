package com.example.roomrent;

import android.os.Parcel;
import android.os.Parcelable;

public class Rooms implements Parcelable {
    private String name_room;
    private String floor;
    private String building;
    private String title;
    private String is_ready;

    public Rooms(String name_room, String floor, String building, String is_ready) {
        this.name_room = name_room;
        this.floor = floor;
        this.building = building;
        this.is_ready = is_ready;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
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
        dest.writeString(this.name_room);
        dest.writeString(this.floor);
        dest.writeString(this.building);
        dest.writeString(this.title);
        dest.writeString(this.is_ready);
    }

    public void readFromParcel(Parcel source) {
        this.name_room = source.readString();
        this.floor = source.readString();
        this.building = source.readString();
        this.title = source.readString();
        this.is_ready = source.readString();
    }

    protected Rooms(Parcel in) {
        this.name_room = in.readString();
        this.floor = in.readString();
        this.building = in.readString();
        this.title = in.readString();
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
