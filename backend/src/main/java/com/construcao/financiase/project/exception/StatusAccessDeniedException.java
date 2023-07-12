package com.construcao.financiase.project.exception;

import com.construcao.financiase.user.enums.Role;
import org.springframework.security.access.AccessDeniedException;

public class StatusAccessDeniedException extends AccessDeniedException {
    public StatusAccessDeniedException(Role role) {
        super(String.format("User with role %s does not have access to this status!", role));
    }
}
