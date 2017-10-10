package com.example.alcanzer.dotastats;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class ProPlayers extends AppCompatActivity {
    RecyclerView mListView;
    ArrayList<ProPlayer> players;
    private CustomAdapter adapter;
    String url = "https://api.opendota.com/api/proPlayers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_players);
        mListView = (RecyclerView) findViewById(R.id.lview);
        mListView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mListView.setLayoutManager(llm);
        players = new ArrayList<>();
        new MyTask().execute(url);


    }


    public class MyTask extends AsyncTask<String, Void, Void> {
        ProPlayer f = null;
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                Gson gson = new Gson();
                JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream()));
                reader.beginArray();
                while(reader.hasNext()) {
                    f = gson.fromJson(reader, ProPlayer.class);
                    if(f.getProfileurl() != null) {
                        players.add(f);
                        Log.d("Nothing", f.toString());
                    }
                }
                reader.endArray();
                reader.close();
                conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter = new CustomAdapter(players,ProPlayers.this);
            mListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
    }
}
