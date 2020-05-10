package com.example.notepad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FragmentDate extends Fragment {
    TextView lastUpdate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, container, false);
        lastUpdate = view.findViewById(R.id.dateLastUpdate);
        lastUpdate.setText(convertDate(new Date()));
        return view;
    }

    public String convertDate(Date date){
        String pattern = "EEE MMM dd, hh:mm:aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en","UK"));
        return simpleDateFormat.format(date);
    }
}
