package com.example.nationinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Nation implements Serializable {
    private String countryName, countryCode;
    private int population;
    private double areaInSqKm;
    private Bitmap imageNation;

    public Nation(String countryName, int population, double areaInSqKm) {
        this.countryName = countryName;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
    }


    public Nation(JSONObject jsonObject) throws JSONException {
        this.countryName = jsonObject.getString("countryName");
        this.population = jsonObject.getInt("population");
        this.areaInSqKm = jsonObject.getDouble("areaInSqKm");
        this.countryCode = jsonObject.getString("countryCode").toLowerCase();
    }

    public Bitmap getImageNation() {
        return imageNation;
    }

    public void setImageNation(Bitmap imageNation) {
        this.imageNation = imageNation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(double areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }
}
