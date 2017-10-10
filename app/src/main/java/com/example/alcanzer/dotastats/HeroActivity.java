package com.example.alcanzer.dotastats;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HeroActivity extends AppCompatActivity {
    ArrayList<HeroStatsObj> heroes;
    GridView gView;
    private HeroAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        gView = (GridView) findViewById(R.id.herogrid);
        setTitle("Heroes");
        heroes = new ArrayList<>();
        new HeroTask().execute("https://api.opendota.com/api/heroStats");
        gView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HeroActivity.this, HeroDetActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(HeroActivity.this, view.findViewById(R.id.heropic), view.findViewById(R.id.heropic).getTransitionName());
                Gson gson = new Gson();
                String obj = gson.toJson(heroes.get(i));
                intent.putExtra("URL", obj);
                startActivity(intent, options.toBundle());
            }
        });
    }

    public class HeroTask extends AsyncTask<String, Void, Void> {
        HeroStatsObj hero = null;
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream()));
                Gson gsn = new Gson();
                reader.beginArray();
                while(reader.hasNext()){
                    hero = gsn.fromJson(reader, HeroStatsObj.class);
                    heroes.add(hero);
                    Log.d("Heroes", hero.getImg());

                }
                reader.endArray();
                reader.close();
                conn.disconnect();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter = new HeroAdapter(heroes, getApplicationContext());
            gView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
