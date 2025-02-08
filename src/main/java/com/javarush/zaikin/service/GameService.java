package com.javarush.zaikin.service;

import com.javarush.zaikin.model.Game;
import com.javarush.zaikin.model.Level;
import com.javarush.zaikin.model.LevelsDB;


public class GameService {
    private Game game;
    private final LevelsDB db = LevelsDB.getInstance();


    public GameService(Game game) {
        this.game = game;
    }

    public void levelUp() {
        Level currentLevel = getLevel();
        int newIndex = db.getLevelsDB().indexOf(currentLevel)+1;
        game.setCurrentLevel(db.getLevelsDB().get(newIndex));
    }
    public boolean checkLose() {
        return game.getHealth() <= 0;
    }
    public boolean checkWin(Level level) {
        return getLevelIndex(level) == getQuestSize();
    }
    public int getQuestSize() {
        return db.getLevelsDB().size();
    }
    public void drinkPotion() {
        if (game.getIsAvailablePotion()) {
            game.setAvailablePotion(false);
            game.setHealth(game.getHealth()+1);
        }
    }
    public Level getLevel() {
        return game.getCurrentLevel();

    }
    public int getLevelIndex(Level level) {
        return db.getLevelsDB().indexOf(level)+1;
    }

    public String getDescForLvl() {
        String description = getLevel().getDescription();
        if (description == null) {
            return "Описание не найдено";
        }
        return description;
    }
    public String getQuestionForLvl() {
        String question = getLevel().getQuestion();
        if (question == null) {
            return "Вопрос отсутствует";
        }
        return question;
    }
    public String[] getAnswersByLvl() {
        String[] answers = getLevel().getAnswers();
        if (answers == null) {
            return new String[]{};
        }
        return answers;
    }

    public String getCorrectAnswer() {
        String correct = getLevel().getCorrect();
        if (correct == null) {
            return "";
        }
        return correct;
    }
    public String getName() {
        return game.getName();
    }
    public int getHealth() {
        return game.getHealth();
    }
    public void decreaseHealth() {
        game.setHealth(game.getHealth() - 1);
    }
    public boolean getIsAvailablePotion() {
        return game.getIsAvailablePotion();
    }
    public boolean getIsTipsOn() {return game.isTipsOn();}

}
