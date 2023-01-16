package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Room extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    private String url = "http://192.168.43.94/RoomRentAPI/public/api/rooms";
    ArrayList<Rooms> listData = new ArrayList<Rooms>();
    Inflater inflater;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);


    }
    public void getAllRoom(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jo = new JSONObject(response);
                    JSONArray ja = jo.getJSONArray("rooms");
                    for (int i = 0; i < ja.length(); i++) {
                        JSONObject data = ja.getJSONObject(i);
                        Log.d("room", "error " + data);
                        listData.add(new Rooms(data.getString("room_name"), data.getString("floor"), data.getString("building"), data.getString("is_ready")));
                    }
                    recyclerView = findViewById(R.id.rvData);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Room.this));
                    recyclerView.setHasFixedSize(true);
                    adapterData = new AdapterData(Room.this, listData);
                    recyclerView.setAdapter(adapterData);
                    adapterData.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Room.this, "failed to fetch data " + error, Toast.LENGTH_SHORT).show();
                Log.d("volley", "error "+error);
            }
        });
        requestQueue.add(stringRequest);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getAllRoom();
    }
}