package com.javarush.zaikin.model;

import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
public class Game {
    private String name;
    private HttpSession session;
    private int energy;
    private Level currentLevel;
    private int health;
    private boolean isAvailableEnergetic;

    public boolean getIsAvailableEnergetic() { // продублировал так как мавен не видит этот геттер ломбока
        return isAvailableEnergetic;
    }



    public Game(String name, HttpSession session, LevelsDB db) {
        this.name = name;
        this.session = session;
        this.energy = 100;
        this.currentLevel = db.getLevelsDB().get(0);
        this.health = 2;
        this.isAvailableEnergetic = true;
    }

}
