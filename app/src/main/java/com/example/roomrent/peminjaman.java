package com.example.roomrent;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Locale;

import butterknife.OnClick;

public class peminjaman extends Fragment {
    private EditText txtTimeStart, txtTimeEnd, txtdate;
    private ImageButton btnstart, btnend, btndate;
    private  int jam,menit;

    @Nullable
    @Override
    public View onCreateView ( LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savBundle ) {
        return inflater.inflate(R.layout.fragment_peminjaman , container , false);
    }


            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.fragment_peminjaman);
                txtTimeStart = txtTimeStart.findViewById(R.id.txtTimeStart);
                txtTimeEnd =txtTimeEnd.findViewById(R.id.txtTimeEnd);
                txtdate =txtdate.findViewById(R.id.txtdate);
                btnend =btnend.findViewById(R.id.btnend);
                btndate = btndate.findViewById(R.id.btndate);
                btnstart =btnstart.findViewById(R.id.btnstart);
                    btnstart.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick ( View view ) {
                    Calendar calendar = Calendar.getInstance();
                    jam = calendar.get(Calendar.HOUR_OF_DAY);
                    menit = calendar.get(Calendar.MINUTE);

                    TimePickerDialog dialog;
                    dialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {



                        @Override
                        public void onTimeSet ( TimePicker timePicker , int hourOfDay , int minute ) {
                            jam = hourOfDay;
                            menit = minute;

                            if (jam <= 12){
                                txtTimeStart.setText(String.format(Locale.getDefault(), "%d:%d am", jam, menit  ));
                            }else {
                                txtTimeStart.setText(String.format(Locale.getDefault(), "%d:$d pm", jam , menit ));
                            }
                        }
                    }, jam,menit,true);
                        dialog.show();
                }
            });
     }
    private void setContentView ( int fragment_peminjaman ) {

    }
}


