package com.construcao.financiase.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    CREATED("Em criação"),
    PENDING("Avaliação Pendente"),
    REJECT("Rejeitado"),
    ACTIVE("Ativo"),
    CLOSED("Encerrado");

    private String description;
}
