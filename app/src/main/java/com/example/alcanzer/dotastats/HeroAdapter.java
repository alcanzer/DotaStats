package com.example.alcanzer.dotastats;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by alcanzer on 9/19/17.
 */

public class HeroAdapter extends BaseAdapter {
    ArrayList<HeroStatsObj> heroes;
    Context ctx;
    LayoutInflater inflater = null;

    public HeroAdapter(ArrayList heroes, Context ctx){
        this.heroes = heroes;
        this.ctx = ctx;
        inflater = LayoutInflater.from(this.ctx);
    }

     public class Holder{
        ImageView img;
        TextView name;
    }
    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if(view == null){
            view = inflater.inflate(R.layout.customgrid, null);
            holder.name = view.findViewById(R.id.heroname);
            holder.img = view.findViewById(R.id.heropic);
            view.setTag(holder);
        }
        else{holder = (Holder) view.getTag();}
        holder.name.setText(heroes.get(i).getLocalized_name());
        Picasso.with(ctx).load(heroes.get(i).getImg()).into(holder.img);
        return view;
    }
}
