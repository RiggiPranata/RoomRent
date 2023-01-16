package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    private String url = "http://192.168.43.94/RoomRentAPI/public/api/register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void cancel(View v){
        startActivity(new Intent(this,Login.class));

    }

    public void submit(View v){

        Toast.makeText(this, "Registration Success" , Toast.LENGTH_SHORT).show();
        postRequest();
        Log.d("volley", "success create user");
        startActivity(new Intent(this,Login.class));
    }

    private void postRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registration.this, "Success Insert data ", Toast.LENGTH_SHORT).show();
                Log.d("volley", "success insert data ");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registration.this, "failed to fetch data " + error, Toast.LENGTH_SHORT).show();
                Log.d("volley", "error "+error);
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email","riggi@gmail.com");
                params.put("password","123456");
//                params.put("confpassword","123456");
                params.put("nama","Riggi");
                params.put("no_telepon","089823412");
                params.put("kelas","7 AM");
                params.put("semester","7");
                params.put("jurusan","Teknik Informatika");
                return params;
            }

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                params.put("Content-Length", "121");
                params.put("Host","localhost");
                return params;
            }

        };
        requestQueue.add(stringRequest);
    }
}