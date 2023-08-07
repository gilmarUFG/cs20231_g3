package com.construcao.financiase.project.exception;

import com.construcao.financiase.project.enums.Category;
import jakarta.persistence.EntityNotFoundException;

public class ProjectNotFoundException extends EntityNotFoundException {

    public ProjectNotFoundException(Long id) {
        super(String.format("Project with id %s not exists!", id));
    }

    public ProjectNotFoundException(Category category) {
        super(String.format("There are no projects with the category %s!", category));
    }
}
