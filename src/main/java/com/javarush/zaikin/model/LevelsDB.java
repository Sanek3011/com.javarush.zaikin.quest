package com.javarush.zaikin.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.InputStream;
import java.util.Comparator;
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
            levelsDB.sort(new Comparator<Level>() {
                @Override
                public int compare(Level o1, Level o2) {
                    return o1.getId() - o2.getId();
                }
            });

        } catch (Exception e) {
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
