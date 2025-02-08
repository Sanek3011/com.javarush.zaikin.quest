package com.javarush.zaikin.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    private String description;
    private String question;
    private String[] answers;
    private String correct;

}

