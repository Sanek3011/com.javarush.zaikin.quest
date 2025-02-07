package com.javarush.zaikin.model;

import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
public class Game {
    private String name;
    private HttpSession session;
    private Level currentLevel;
    private int health;
    private boolean isAvailablePotion;

    public boolean getIsAvailablePotion() { // продублировал так как мавен не видит этот геттер ломбока
        return isAvailablePotion;
    }



    public Game(String name, HttpSession session, LevelsDB db) {
        this.name = name;
        this.session = session;
        this.currentLevel = db.getLevelsDB().get(0);
        this.health = 2;
        this.isAvailablePotion = true;
    }

}
