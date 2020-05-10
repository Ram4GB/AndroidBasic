package com.example.landingmark;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapterPoint arrayAdapterPoint;
    ArrayList<Point> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        list =  new ArrayList<>();

        list.add(new Point("SGU University","geo:10.760059,106.681768?z=zoom","https://sgu.edu.vn/?lang=en"));
        list.add(new Point("Fit SGU","geo:10.760059,106.681768?z=zoom","https://fit.sgu.edu.vn/site/"));
        list.add(new Point("Cleveland State University","geo:10.760059,106.681768?z=zoom","https://sgu.edu.vn/?lang=en"));
        list.add(new Point("Playhouse Square","geo:10.760059,106.681768?z=zoom","https://sgu.edu.vn/?lang=en"));

        arrayAdapterPoint = new ArrayAdapterPoint(this,R.layout.custom_list_item, list);

        listView.setAdapter(arrayAdapterPoint);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogCustom(list.get(position));
            }
        });
    }


    public void DialogCustom (final Point point) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);

        Button moreInfor, mapIt;
        TextView title;

        moreInfor = dialog.findViewById(R.id.moreInfor);
        mapIt = dialog.findViewById(R.id.mapIt);
        title = dialog.findViewById(R.id.title);

        title.setText(point.getTitle());

        mapIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(point.getPoint()));
                // view SGU University
                intent.setPackage("com.google.android.apps.maps");
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        moreInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebView.class);
                intent.putExtra("link", point.getLinkUrl());
                startActivity(intent);
            }
        });

        dialog.show();
    }
}
