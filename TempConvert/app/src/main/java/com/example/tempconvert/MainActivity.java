package com.example.tempconvert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton fToCRadio, cToFRadio;
    EditText editTextLeft, editTextRight;
    Button buttonConvert;
    ListView listView;
    ArrayList <String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textLeft;
                double result = 0;
                textLeft = editTextLeft.getText().toString();
                if(!textLeft.isEmpty()){
                    // check Radio button
                    if(fToCRadio.isChecked()){
                        result = ( Double.valueOf(textLeft) - 32.0 ) * 5.0 / 9.0;
                        result = (double) Math.round(result*100)/100;
                        list.add("F to C: " + textLeft+" => "+result);
                        editTextRight.setText(String.valueOf(result));
                        adapter.notifyDataSetChanged();
                    }else{
                        result = ( Double.valueOf(textLeft) * 9.0 / 5.0 ) + 32.0;
                        result = (double) Math.round(result*100)/100;
                        list.add("C to F: " + textLeft+" => "+result);
                        editTextRight.setText(String.valueOf(result));
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Please enter something",Toast.LENGTH_SHORT).show();
                }
                Log.d("AAA",list.toString());
            }
        });

        if(savedInstanceState != null){
            list = savedInstanceState.getStringArrayList("listResult");
//            adapter.notifyDataSetChanged();
            adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
            editTextLeft.setText(savedInstanceState.getString("editTextLeft"));
            editTextRight.setText(savedInstanceState.getString("editTextRight"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("listResult",list);
        outState.putString("editTextLeft",editTextLeft.getText().toString());
        outState.putString("editTextRight",editTextRight.getText().toString());
    }

    public void mapping() {
        fToCRadio = findViewById(R.id.fToC);
        cToFRadio = findViewById(R.id.cToF);
        editTextLeft = findViewById(R.id.editTextLeft);
        editTextRight = findViewById(R.id.editTextRight);
        buttonConvert = findViewById(R.id.buttonConvert);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
