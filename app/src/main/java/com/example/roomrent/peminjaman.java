package com.example.roomrent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.OnClick;

public class peminjaman extends AppCompatActivity {
    private EditText txtTimeStart, txtTimeEnd, txtdate;
    private String url = "http://192.168.43.94/RoomRentAPI/public/api/rents";
    private Button buttonSubmit;
    private ImageButton btnstart, btnend, btndate;
    private  int jam,menit, year,month,monthJan,day;
    SharedPreferences sharedPreferences;


            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_peminjaman);
                sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

                txtTimeStart = findViewById(R.id.txtTimeStart);
                txtTimeEnd =findViewById(R.id.txtTimeEnd);
                txtdate =findViewById(R.id.txtdate);
                btnend =findViewById(R.id.btnend);
                btndate = findViewById(R.id.btndate);
                buttonSubmit = findViewById(R.id.buttonSubmitPinjaman);
                btnstart =findViewById(R.id.btnstart);
                btnstart.setOnClickListener(view1 -> {
                    Calendar calendar = Calendar.getInstance();
                    jam = calendar.get(Calendar.HOUR_OF_DAY);
                    menit = calendar.get(Calendar.MINUTE);

                    TimePickerDialog dialog;
                    dialog = new TimePickerDialog(this, (timePicker, hourOfDay, minute) -> {
                        jam = hourOfDay;
                        menit = minute;

                        txtTimeStart.setText(String.format(Locale.getDefault(), "%d:%d:00", jam , menit ));

                    }, jam,menit,true);
                    dialog.show();
                });
                btnend.setOnClickListener(view1 -> {
                    Calendar calendar = Calendar.getInstance();
                    jam = calendar.get(Calendar.HOUR_OF_DAY);
                    menit = calendar.get(Calendar.MINUTE);

                    TimePickerDialog dialog;
                    dialog = new TimePickerDialog(this, (timePicker, hourOfDay, minute) -> {
                        jam = hourOfDay;
                        menit = minute;

                        txtTimeEnd.setText(String.format(Locale.getDefault(), "%d:%d:00", jam , menit ));

                    }, jam,menit,true);
                    dialog.show();
                });
                btndate.setOnClickListener(view1 -> {
                    Calendar calendar = Calendar.getInstance();
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    day = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog;
                    dialog = new DatePickerDialog(this, (view2, year1, month1, dayOfMonth) -> {
                        year = year1;
                        month = month1+1 ;
                        day = dayOfMonth;
                        if (month == 10 | month == 11 | month == 12){
                            txtdate.setText(year+"-"+month+"-"+day);
                        }else{
                            txtdate.setText(year+"-0"+month+"-"+day);
                        }



                    }, year,month,day);
                    dialog.show();
                });

                buttonSubmit.setOnClickListener(v -> postRequest());

            }

    private void postRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(peminjaman.this, "Success Insert data ", Toast.LENGTH_SHORT).show();
                Log.d("volley", "success insert data ");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(peminjaman.this, "failed to fetch data " + error, Toast.LENGTH_SHORT).show();
                Log.d("volley", "error "+error);
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("room_id","2");
                params.put("user_id","1");
                params.put("time_start","00:00:00");
                params.put("time_end","24:00:00");
                params.put("date","2023-01-18");
                params.put("nama","test");
                params.put("no_telepon","089823412");
                params.put("remark","ujian uas");
                return params;
            }

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                params.put("Content-Length", "130");
                params.put("Host","localhost");
                return params;
            }

        };
        requestQueue.add(stringRequest);
    }



}


