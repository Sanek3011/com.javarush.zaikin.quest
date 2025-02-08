package com.javarush.zaikin.model;

import lombok.Data;

@Data
public class Game {
    private String name;
    private Level currentLevel;
    private int health;
    private boolean isAvailablePotion;
    private boolean isTipsOn;

    public boolean getIsAvailablePotion() { // продублировал так как мавен не видит этот геттер ломбока
        return isAvailablePotion;
    }



    public Game(String name, LevelsDB db, boolean isTipsOn) {
        this.name = name;
        this.currentLevel = db.getLevelsDB().get(0);
        this.health = 2;
        this.isAvailablePotion = true;
        this.isTipsOn = isTipsOn;
    }

}
