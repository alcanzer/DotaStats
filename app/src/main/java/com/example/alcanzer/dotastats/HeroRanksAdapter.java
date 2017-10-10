package com.example.alcanzer.dotastats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by alcanzer on 9/25/17.
 */

public class HeroRanksAdapter extends RecyclerView.Adapter<HeroRanksAdapter.ViewHolder>{
    Ranks[] ranks = null;
    Context ctx;
    public HeroRanksAdapter(Ranks[] ranks, Context ctx){
        this.ranks = ranks;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_ranks_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int i = position+1;
        Ranks rank = ranks[position];
        holder.playerName.setText(rank.getName() == null ? rank.getPersonaname() : rank.getName());
        holder.mmr.setText(rank.getSolo_competitive_rank()+"");
        holder.pScore.setText(rank.getScore()+"");
        holder.rankno.setText(i+"");
        Picasso.with(ctx).load(rank.getAvatar()).into(holder.playerPic);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView rankno;
        protected ImageView playerPic;
        protected TextView playerName;
        protected TextView mmr;
        protected TextView pScore;
        public ViewHolder(View itemView) {
            super(itemView);
            rankno = itemView.findViewById(R.id.rank);
            playerPic = itemView.findViewById(R.id.rankpic);
            playerName = itemView.findViewById(R.id.rankname);
            mmr = itemView.findViewById(R.id.mmr);
            pScore = itemView.findViewById(R.id.points);
        }
    }
}
