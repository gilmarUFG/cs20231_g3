package com.construcao.financiase.user.exception;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long id) {
        super(String.format("User with id %s not exists!", id));
    }

    public UserNotFoundException(String email) {
        super(String.format("User with id %s not exists!", email));
    }
}
