package com.example.alcanzer.dotastats;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alcanzer on 9/16/17.
 */

public class ProPlayer implements Serializable{
    String account_id;
    long steamId;
    String avatar;
    String avatarmedium;
    String avatarfull;
    String profileurl;
    String personaname;
    String last_login;
    String full_history_time;
    int cheese;
    boolean fh_unavailable;
    String loccountrycode;
    String last_match_time;
    String name;
    String country_code;
    int fantasy_role;
    int team_id;
    String team_name;
    String team_tag;
    boolean is_locked;
    boolean is_pro;
    int locked_until;

    public String getAccount_id() {
        return account_id;
    }

    public long getSteamId() {
        return steamId;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public String getPersonaname() {
        return personaname;
    }

    public String getLast_login() {
        return last_login;
    }

    public String getFull_history_time() {
        return full_history_time;
    }

    public int getCheese() {
        return cheese;
    }

    public boolean isFh_unavailable() {
        return fh_unavailable;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public String getLast_match_time() {
        return last_match_time;
    }

    public String getName() {
        return name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public int getFantasy_role() {
        return fantasy_role;
    }

    public int getTeam_id() {
        return team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getTeam_tag() {
        return team_tag;
    }

    public boolean is_locked() {
        return is_locked;
    }

    public boolean is_pro() {
        return is_pro;
    }

    public int getLocked_until() {
        return locked_until;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
