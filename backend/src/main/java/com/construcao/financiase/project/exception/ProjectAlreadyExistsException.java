package com.construcao.financiase.project.exception;

import jakarta.persistence.EntityExistsException;

public class ProjectAlreadyExistsException extends EntityExistsException {

    public ProjectAlreadyExistsException(String title) {
        super(String.format("Project with name %s already exists!", title));
    }
}
