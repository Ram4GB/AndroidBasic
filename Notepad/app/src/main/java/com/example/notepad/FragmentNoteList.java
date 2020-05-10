package com.example.notepad;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;

public class FragmentNoteList extends Fragment {
    TextView textView;
    FragmentDate fragmentDate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        textView = view.findViewById(R.id.listTodo);
        fragmentDate = (FragmentDate) getFragmentManager().findFragmentById(R.id.fragmentDate);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String lastUpdate = fragmentDate.convertDate(new Date());
                fragmentDate.lastUpdate.setText(lastUpdate);
            }
        });
        return view;
    }
}
