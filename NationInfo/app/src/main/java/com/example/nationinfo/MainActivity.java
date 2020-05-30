package com.example.nationinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewNation;
    ArrayList<Nation> arrayListNation;
    ArrayAdapterNation arrayAdapterNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://api.geonames.org/countryInfoJSON?formatted=true&lang=it&countarrayListNationry=&username=leminhcuong2988&style=full";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("geonames");
                    arrayListNation = new ArrayList<>();
                    for (int i = 0 ; i < jsonArray.length(); i++){
                        arrayListNation.add(new Nation(jsonArray.getJSONObject(i)));
                    }

                    arrayAdapterNation = new ArrayAdapterNation(arrayListNation,R.layout.row_nation, MainActivity.this);
                    listViewNation.setAdapter(arrayAdapterNation);
                } catch (JSONException e) {
                    Log.d("AA",e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("AAAA", error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);

        event();
    }

    private  void event(){
        listViewNation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", arrayListNation.get(position));
                Intent intent = new Intent(MainActivity.this, NationInfomation.class);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }
    private void mapping() {
        listViewNation = findViewById(R.id.lv_list_nation);
    }
}
