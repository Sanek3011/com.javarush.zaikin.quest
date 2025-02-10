package com.javarush.zaikin.service;

import com.javarush.zaikin.model.Game;
import com.javarush.zaikin.model.Level;
import com.javarush.zaikin.model.LevelsDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private static GameService service;
    private static Game game;
    private static Level levelNull;
    private static Level levelDefault;
    @BeforeEach
    public void init() {
        game = new Game("Name", LevelsDB.getInstance(), true);
        service = Mockito.spy(new GameService(game));
        levelNull = new Level(null, null, null, null);
        levelDefault = new Level("Описание", "Вопрос", new String[]{"ответ","ответ"}, "ответ");
    }

    @Test
    void levelUp() {
        Level expectedLevel = LevelsDB.getInstance().getLevelsDB().get(1);
        service.levelUp();
        assertEquals(expectedLevel, service.getLevel());


    }

    @Test
    void checkLose() {
        game.setHealth(0);
        assertTrue(service.checkLose());
    }

    @Test
    void checkWin() {
        List<Level> levelsDB = LevelsDB.getInstance().getLevelsDB();
        Level level = levelsDB.get(levelsDB.size() - 1);
        game.setCurrentLevel(level);
        assertTrue(service.checkWin(level));
    }

    @Test
    void drinkPotionWithTrue() {
        int health = game.getHealth();
        service.drinkPotion();
        assertEquals(health+1, game.getHealth());
    }
    @Test
    void drinkPotionWithFalse() {
        int health = game.getHealth();
        game.setAvailablePotion(false);
        service.drinkPotion();
        assertEquals(health, game.getHealth());

    }

    @Test
    void getLevelIndex() {
        Level currentLevel = game.getCurrentLevel();
        LevelsDB.getInstance().getLevelsDB().indexOf(currentLevel);
        int levelIndex = service.getLevelIndex(currentLevel);
        assertEquals(1, levelIndex);
    }

    @Test
    void getDescForLvl() {
        Mockito.when(service.getLevel()).thenReturn(levelDefault);
        assertEquals("Описание", service.getDescForLvl());

    }
    @Test
    void getDescForLvlWithNull() {
        Mockito.when(service.getLevel()).thenReturn(levelNull);
        assertEquals("Описание не найдено", service.getDescForLvl());


    }

    @Test
    void getQuestionForLvl() {
        Mockito.when(service.getLevel()).thenReturn(levelDefault);
        assertEquals("Вопрос", service.getQuestionForLvl());
    }

    @Test
    void getQuestionForLvlWithNull() {
        Mockito.when(service.getLevel()).thenReturn(levelNull);
        assertEquals("Вопрос отсутствует", service.getQuestionForLvl());

    }

    @Test
    void getAnswersByLvl() {
        Mockito.when(service.getLevel()).thenReturn(levelDefault);
        String[] tmp = new String[]{"ответ","ответ"};
        assertArrayEquals(tmp, service.getAnswersByLvl());

    }
    @Test
    void getAnswersByLvlWithNull() {
        Mockito.when(service.getLevel()).thenReturn(levelNull);
        assertArrayEquals(new String[]{}, service.getAnswersByLvl());
    }

    @Test
    void getCorrectAnswer() {
        Mockito.when(service.getLevel()).thenReturn(levelDefault);
        assertEquals("ответ", service.getCorrectAnswer());
    }
    @Test
    void getCorrectAnswerWithNull() {
        Mockito.when(service.getLevel()).thenReturn(levelNull);
        assertEquals("", service.getCorrectAnswer());
    }

    @Test
    void decreaseHealth() {
        int health = game.getHealth();
        service.decreaseHealth();
        assertEquals(health-1, service.getHealth());
    }
}