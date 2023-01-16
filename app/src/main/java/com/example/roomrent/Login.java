package com.example.roomrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {
    EditText EmailLogin, PasswordLogin;
    SharedPreferences sharedPreferences;
    static String KEY_USER = "email_user";

    private String url = "http://192.168.43.94/RoomRentAPI/public/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailLogin = findViewById(R.id.txtEmailLogin);
        PasswordLogin = findViewById(R.id.txtPasswordLogin);
        sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

        String emailUser = sharedPreferences.getString(Login.KEY_USER, null);
        if (emailUser != null){
            Toast.makeText(this, "Login Sebagai "+emailUser , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, screen_home.class));
        }

    }

    public void login(View v){
        String emailUser = EmailLogin.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER, emailUser);
        editor.commit();
        Toast.makeText(this, "Success Login Sebagai "+emailUser , Toast.LENGTH_SHORT).show();
        postRequest();
        Log.d("volley", "success login");
        startActivity(new Intent(this, screen_home.class));
    }

    public void registration(View view) {
        startActivity(new Intent(this, Registration.class));
    }

    private void postRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Login.this, "User Login succesfully ", Toast.LENGTH_SHORT).show();
                Log.d("volley", "success insert data ");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "failed to fetch data " + error, Toast.LENGTH_SHORT).show();
                Log.d("volley", "error "+error);
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email","riggi@gmail.com");
                params.put("password","123456");
                return params;
            }

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                params.put("Content-Length", "40");
                params.put("Host","localhost");
                return params;
            }

        };
        requestQueue.add(stringRequest);
    }
}