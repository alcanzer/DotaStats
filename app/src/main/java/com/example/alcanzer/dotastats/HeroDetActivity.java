package com.example.alcanzer.dotastats;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HeroDetActivity extends AppCompatActivity {
    ImageView img;
    RecyclerView rView;
    Ranks[] rank = null;
    private HeroRanksAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_hero_det_acitivity);
        img = (ImageView) findViewById(R.id.expandedImage);
        rView = (RecyclerView) findViewById(R.id.ranksList);
        final CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout abl = (AppBarLayout) findViewById(R.id.app_bar_layout);
        Gson gson = new Gson();
        final HeroStatsObj hero = gson.fromJson(getIntent().getStringExtra("URL"), HeroStatsObj.class);
        Picasso.with(this).load(hero.getImg()).into(img);
        Log.d("HeroId", "https://api.opendota.com/api/rankings?hero_id="+hero.getHero_id());
        new MyRanks().execute("https://api.opendota.com/api/rankings?hero_id="+hero.getHero_id());
        rView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(llm);
        abl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0){
                    ctl.setTitle(hero.getLocalized_name());
                    isShow = true;
                }
                else if(isShow){
                    ctl.setTitle(" ");
                    isShow = false;
                }

            }
        });

    }

    public class MyRanks extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                Gson gson = new Gson();
                JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream()));
                JsonParser parser = new JsonParser();
                JsonObject obj = parser.parse(reader).getAsJsonObject();
                rank = gson.fromJson(obj.get("rankings"), Ranks[].class);
                /*reader.beginObject();
                rank = gson.fromJson(reader, Rankings.class);
                reader.endObject();*/
                reader.close();
                conn.disconnect();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter = new HeroRanksAdapter(rank, HeroDetActivity.this);
            rView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
