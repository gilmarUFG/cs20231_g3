package com.construcao.financiase.user.exception;

import jakarta.persistence.EntityExistsException;

public class UserEmailAlreadyExistsException extends EntityExistsException {

    public UserEmailAlreadyExistsException(String email) {
        super(String.format("User with email %s already exists", email));
    }
}
