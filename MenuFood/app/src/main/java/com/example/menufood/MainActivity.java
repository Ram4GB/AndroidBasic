package com.example.menufood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton large, medium, corn, flour;
    CheckBox beef, chicken, riceBean, beans, seaFood, whiteFish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        large = findViewById(R.id.largeSize);
        medium = findViewById(R.id.mediumSize);
        corn = findViewById(R.id.corn);
        flour = findViewById(R.id.flour);

        beef = findViewById(R.id.beef);
        chicken = findViewById(R.id.chicken);
        riceBean = findViewById(R.id.riceBean);
        beans = findViewById(R.id.beans);
        seaFood = findViewById(R.id.seaFood);
        whiteFish = findViewById(R.id.whiteFish);
    }

    public void placeYourOrder(View view){
        String s = "I'M HUNGRY. LET BRING ME \n";
        String size = "";
        String tortilla = "";

        if(large.isChecked())
            size += "Size: large";
        if(medium.isChecked())
            size += "Size: medium";
        if(corn.isChecked())
            tortilla += "Tortilla: corn";
        if(flour.isChecked())
            tortilla += "Tortilla: flour";

        ArrayList<String> fillings = new ArrayList<>();

        if(beef.isChecked())
            fillings.add("Beef");
        if(chicken.isChecked())
            fillings.add("Chicken");
        if(whiteFish.isChecked())
            fillings.add("White Fish");
        if(riceBean.isChecked())
            fillings.add("Rice Bean");
        if(beans.isChecked())
            fillings.add("Beans");
        if(seaFood.isChecked())
            fillings.add("Sea Food");

        s = s + size + "\n" + tortilla + "\n";

        if(fillings.size() > 0){
            s = s + "Fillings: ";
            for(int i = 0 ; i < fillings.size(); i++){
                s += fillings.get(i);
                if(i != fillings.size() - 1) s += ", ";
            }
        }

        String phoneNumer = "0768916640";
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+ phoneNumer));
        intent.putExtra("sms_body", s);
        startActivity(intent);
    }
}
