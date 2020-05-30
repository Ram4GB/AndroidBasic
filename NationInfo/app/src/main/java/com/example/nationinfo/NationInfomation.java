package com.example.nationinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NationInfomation extends AppCompatActivity {
    TextView nationName, nationPopulations, nationArea, textProgress;
    ImageView imageViewNationInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation_infomation);

        nationName = findViewById(R.id.nationNameInfo);
        nationPopulations = findViewById(R.id.populations);
        nationArea = findViewById(R.id.area);
        imageViewNationInfo = findViewById(R.id.imageViewNationInfo);
        textProgress = findViewById(R.id.textProgress);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        Nation nation = (Nation) bundle.getSerializable("data");

        final String urlImage = "https://img.geonames.org/flags/x/"+nation.getCountryCode()+".gif";

        new AsyncTask<Void, Void, Bitmap>(){

            @Override
            protected Bitmap doInBackground(Void... voids) {

                URL url = null;
                try {
                    url = new URL(urlImage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection connection = null;
                try {
                    connection = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connection.setDoInput(true);
                try {
                    connection.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InputStream input = null;
                try {
                    input = connection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                if(result != null){
                    imageViewNationInfo.setImageBitmap(result);
                    textProgress.setText("");
                }
            }
        }.execute();
        nationName.setText(nation.getCountryName());
        nationArea.setText("Nation area is: "+nation.getAreaInSqKm()+ " (Square km)");
        nationPopulations.setText("Nation populations is : "+nation.getPopulation() + " (people)");
    }

}
