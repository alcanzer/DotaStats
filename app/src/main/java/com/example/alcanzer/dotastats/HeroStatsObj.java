package com.example.alcanzer.dotastats;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alcanzer on 9/19/17.
 */

public class HeroStatsObj implements Parcelable{
    String BASE_URL = "https://api.opendota.com";
    int id;
    String name;
    String localized_name;
    String primary_attr;
    String attack_type;
    String[] roles;
    String img;
    String icon;
    int base_health;
    float base_health_regen;
    int base_mana;
    float base_mana_regen;
    int base_armour;
    int base_mr;
    int base_attack_min;
    int base_attack_max;
    int base_str;
    int base_agi;
    int base_int;
    double str_gain;
    double agi_gain;
    double int_gain;
    int attack_range;
    int projectile_speed;
    double attack_rate;
    int move_speed;
    double turn_rate;
    boolean cm_enabled;
    int legs;
    int pro_ban;
    int hero_id;
    int pro_win;
    int pro_pick;

    int pick_1000;
    int win_1000;
    int pick_2000;
    int win_2000;
    int pick_3000;
    int win_3000;
    int pick_4000;
    int win_4000;
    int pick_5000;
    int win_5000;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getImg() {
        return BASE_URL+img;
    }

    public String getIcon() {
        return icon;
    }

    public int getBase_health() {
        return base_health;
    }

    public float getBase_health_regen() {
        return base_health_regen;
    }

    public int getBase_mana() {
        return base_mana;
    }

    public float getBase_mana_regen() {
        return base_mana_regen;
    }

    public int getBase_armour() {
        return base_armour;
    }

    public int getBase_mr() {
        return base_mr;
    }

    public int getBase_attack_min() {
        return base_attack_min;
    }

    public int getBase_attack_max() {
        return base_attack_max;
    }

    public int getBase_str() {
        return base_str;
    }

    public int getBase_agi() {
        return base_agi;
    }

    public int getBase_int() {
        return base_int;
    }

    public double getStr_gain() {
        return str_gain;
    }

    public double getAgi_gain() {
        return agi_gain;
    }

    public double getInt_gain() {
        return int_gain;
    }

    public int getAttack_range() {
        return attack_range;
    }

    public int getProjectile_speed() {
        return projectile_speed;
    }

    public double getAttack_rate() {
        return attack_rate;
    }

    public int getMove_speed() {
        return move_speed;
    }

    public double getTurn_rate() {
        return turn_rate;
    }

    public boolean isCm_enabled() {
        return cm_enabled;
    }

    public int getLegs() {
        return legs;
    }

    public int getPro_ban() {
        return pro_ban;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getPro_win() {
        return pro_win;
    }

    public int getPro_pick() {
        return pro_pick;
    }

    public int getPick_1000() {
        return pick_1000;
    }

    public int getWin_1000() {
        return win_1000;
    }

    public int getPick_2000() {
        return pick_2000;
    }

    public int getWin_2000() {
        return win_2000;
    }

    public int getPick_3000() {
        return pick_3000;
    }

    public int getWin_3000() {
        return win_3000;
    }

    public int getPick_4000() {
        return pick_4000;
    }

    public int getWin_4000() {
        return win_4000;
    }

    public int getPick_5000() {
        return pick_5000;
    }

    public int getWin_5000() {
        return win_5000;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
