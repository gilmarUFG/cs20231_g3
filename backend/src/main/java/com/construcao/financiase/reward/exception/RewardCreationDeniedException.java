package com.construcao.financiase.reward.exception;

public class RewardCreationDeniedException extends RuntimeException {
    public RewardCreationDeniedException() {
        super("Creation of reward denied.");
    }
}
