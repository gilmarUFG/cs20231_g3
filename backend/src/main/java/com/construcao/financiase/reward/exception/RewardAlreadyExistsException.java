package com.construcao.financiase.reward.exception;

import jakarta.persistence.EntityExistsException;

public class RewardAlreadyExistsException extends EntityExistsException {

    public RewardAlreadyExistsException(int value ) {
        super(String.format("Reward with value %s already exists!", value));
    }

}
