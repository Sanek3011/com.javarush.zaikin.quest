package com.javarush.zaikin.service;

import com.javarush.zaikin.model.Game;
import com.javarush.zaikin.model.Level;
import com.javarush.zaikin.model.LevelsDB;
import jakarta.servlet.http.HttpSession;


public class GameService {
    private Game game;
    LevelsDB db = LevelsDB.getInstance();


    public GameService(Game game) {
        this.game = game;
    }

    public void levelUp() {
        Level currentLevel = game.getCurrentLevel();
        int newIndex = db.getLevelsDB().indexOf(currentLevel)+1;
        game.setCurrentLevel(db.getLevelsDB().get(newIndex));
        game.setEnergy(game.getEnergy()-10);
    }
    public boolean checkLose() {
        return game.getEnergy() <= 0 || game.getHealth() == 0;
    }
    public boolean checkWin() {
        return game.getCurrentLevel().getId() == 20;
    }
    public void drinkEnergetic() {
        if (game.getIsAvailableEnergetic()) {
            game.setAvailableEnergetic(false);
            game.setEnergy(game.getEnergy()+100);
        }
    }
    public Level getLevel() {
        return game.getCurrentLevel();

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
    public boolean getIsAvailableEnergetic() {
        return game.getIsAvailableEnergetic();
    }
    public HttpSession getSession() {
        return game.getSession();
    }
    public String getName() {
        return game.getName();
    }
    public int getEnergy() {
        return game.getEnergy();
    }
    public int getHealth() {
        return game.getHealth();
    }
    public void decreaseHealth() {
        game.setHealth(game.getHealth() - 1);
    }


}
