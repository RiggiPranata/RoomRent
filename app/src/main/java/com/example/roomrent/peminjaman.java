package com.example.roomrent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class peminjaman extends Fragment {
@Nullable
@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savBundle )
{

        return inflater.inflate(R.layout.fragment_peminjaman, container, false);
    }
}