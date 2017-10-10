package com.example.alcanzer.dotastats;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alcanzer on 9/25/17.
 */

public class Ranks {
        @SerializedName("account_id")
        int account_id;
    @SerializedName("score")
        float score;
    @SerializedName("personaname")
        String personaname;
    @SerializedName("name")
        String name;
    @SerializedName("avatar")
        String avatar;
    @SerializedName("last_login")
        String last_login;
    @SerializedName("solo_competitive_rank")
        int solo_competitive_rank;

    public int getAccount_id() {
        return account_id;
    }

    public float getScore() {
        return score;
    }

    public String getPersonaname() {
        return personaname;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLast_login() {
        return last_login;
    }

    public int getSolo_competitive_rank() {
        return solo_competitive_rank;
    }
}
