package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Food> listFood;
    FoodAdapter foodAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFood = new ArrayList<>();
        listFood.add(new Food("Taco Yummy",R.drawable.anh1,R.drawable.image,"https://www.gimmesomeoven.com/",R.drawable.anh3));
        listFood.add(new Food("Taco Soup",R.drawable.anh2,R.drawable.image,"https://www.gimmesomeoven.com/",R.drawable.anh4));

        foodAdapter = new FoodAdapter(listFood, R.layout.list_item, MainActivity.this);

        listView = findViewById(R.id.listView);
        listView.setAdapter(foodAdapter);
    }
}
