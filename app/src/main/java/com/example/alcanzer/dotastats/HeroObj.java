package com.example.alcanzer.dotastats;

/**
 * Created by alcanzer on 9/19/17.
 */

public class HeroObj {
    int id;
    String name;
    String localized_name;
    String primary_attr;
    String attack_type;
    String roles[];
    int legs;

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

    public int getLegs() {
        return legs;
    }
}
