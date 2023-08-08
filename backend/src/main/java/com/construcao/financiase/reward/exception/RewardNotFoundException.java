package com.construcao.financiase.reward.exception;

import jakarta.persistence.EntityNotFoundException;

public class RewardNotFoundException extends EntityNotFoundException {

    public RewardNotFoundException(Long id) {
        super(String.format("No rewards found for the project %s", id));
    }
}
