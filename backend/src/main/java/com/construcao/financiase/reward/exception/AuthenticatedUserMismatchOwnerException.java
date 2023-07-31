package com.construcao.financiase.reward.exception;

public class AuthenticatedUserMismatchOwnerException extends RuntimeException{

    public AuthenticatedUserMismatchOwnerException(Long id) {
        super(String.format("User with id %s is not the owner of the project", id));
    }
}
