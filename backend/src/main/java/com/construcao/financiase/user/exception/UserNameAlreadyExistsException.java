package com.construcao.financiase.user.exception;

import jakarta.persistence.EntityExistsException;

public class UserNameAlreadyExistsException extends EntityExistsException {

    public UserNameAlreadyExistsException(String username) {
        super(String.format("User with username %s already exists", username));
    }
}
