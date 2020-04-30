package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class LoadImage extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        imageView = findViewById(R.id.bigImage);

        Intent intent = getIntent();
        int imageID = intent.getIntExtra("imageID",0);

        imageView.setImageResource(imageID);
    }
}
