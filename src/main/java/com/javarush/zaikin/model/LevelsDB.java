package com.javarush.zaikin.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
public class LevelsDB {
    private static LevelsDB INSTANCE;
    @Getter
    private List<Level> levelsDB;

    private LevelsDB() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream input = LevelsDB.class.getClassLoader().getResourceAsStream("levels.json")) {
            levelsDB = objectMapper.readValue(input, new TypeReference<List<Level>>() {
            });
            Collections.shuffle(levelsDB);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при чтении вопросов");
        }

    }

    public static LevelsDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LevelsDB();
        }
        return INSTANCE;
    }
}
