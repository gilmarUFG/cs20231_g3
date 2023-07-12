package com.construcao.financiase.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    ARTS("Artes"),
    GAMES("Jogos"),
    MUSIC("Musica");

    private String description;
}
