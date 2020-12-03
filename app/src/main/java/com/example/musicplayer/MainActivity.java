package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

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

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SongAdapter mSongAdapter;
    private ArrayList<Song> mArrayList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mRecyclerView = findViewById(R.id.songRecyler);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            mArrayList = new ArrayList<>();

            mRequestQueue = Volley.newRequestQueue(this);
            parseJson();
        }


        private void parseJson(){
            String url = "http://www.objgen.com/json/models/YVV";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.getJSONArray("hits");
                                for(int i = 0; i < jsonArray.length(); i++){
                                    JSONObject hit = jsonArray.getJSONObject(i);
                                    String songName = hit.getString("songName");
                                    String singerName = hit.getString("singerName");
                                    String urlImage = hit.getString("webformatURL");
                                    String time = hit.getString("time");


                                    mArrayList.add(new Song(urlImage,songName,singerName,time));

                                }
                                mSongAdapter = new SongAdapter(MainActivity.this, mArrayList);
                                mRecyclerView.setAdapter(mSongAdapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mRequestQueue.add(request);
        }
    }