package com.example.alcanzer.dotastats;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alcanzer on 9/16/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    ArrayList<ProPlayer> players;
    Context ctx;

    public CustomAdapter(ArrayList<ProPlayer> players, Context ctx){
        this.players = players;
        this.ctx = ctx;
    }

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customlv, parent, false);
        return new CustomHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, final int position) {
        holder.chevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, players.get(position).getProfileurl()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx, Homepage.class);
                ctx.startActivity(intent);
            }
        });
        Picasso.with(ctx).load(players.get(position).getAvatarfull()).into(holder.img);
        holder.lastMatch.setText(players.get(position).getLast_match_time());
        holder.name.setText(players.get(position).getPersonaname());
        holder.country.setText(players.get(position).getLoccountrycode());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }



    public class CustomHolder extends RecyclerView.ViewHolder{
        protected ImageView img;
        protected TextView name;
        protected TextView lastMatch;
        protected TextView country;
        protected ImageView chevron;
        public CustomHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgV);
            name = itemView.findViewById(R.id.persname);
            lastMatch = itemView.findViewById(R.id.lastmatch);
            country = itemView.findViewById(R.id.country);
            chevron = itemView.findViewById(R.id.chevron);
        }
    }
}
