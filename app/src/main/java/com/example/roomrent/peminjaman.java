package com.example.roomrent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Calendar;
import java.util.Locale;

import butterknife.OnClick;

public class peminjaman extends Fragment {
    private EditText txtTimeStart, txtTimeEnd, txtdate;
    private ImageButton btnstart, btnend, btndate;
    private  int jam,menit, year,month,monthJan,day;

    @Nullable
    @Override
    public View onCreateView ( LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savBundle ) {
        return inflater.inflate(R.layout.fragment_peminjaman , container , false);
    }


            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);



         }
                @Override
                public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                    super.onViewCreated(view, savedInstanceState);

                    txtTimeStart = view.findViewById(R.id.txtTimeStart);
                    txtTimeEnd =view.findViewById(R.id.txtTimeEnd);
                    txtdate =view.findViewById(R.id.txtdate);
                    btnend =view.findViewById(R.id.btnend);
                    btndate = view.findViewById(R.id.btndate);
                    btnstart =view.findViewById(R.id.btnstart);
                    btnstart.setOnClickListener(view1 -> {
                        Calendar calendar = Calendar.getInstance();
                        jam = calendar.get(Calendar.HOUR_OF_DAY);
                        menit = calendar.get(Calendar.MINUTE);

                        TimePickerDialog dialog;
                        dialog = new TimePickerDialog(getContext(), (timePicker, hourOfDay, minute) -> {
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
                        dialog = new TimePickerDialog(getContext(), (timePicker, hourOfDay, minute) -> {
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
                        dialog = new DatePickerDialog(getContext(), (view2, year1, month1, dayOfMonth) -> {
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


                }


}


