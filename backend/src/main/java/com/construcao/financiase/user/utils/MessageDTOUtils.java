package com.construcao.financiase.user.utils;

import com.construcao.financiase.user.dto.MessageDTO;
import com.construcao.financiase.user.entity.User;

public class MessageDTOUtils {

    public static MessageDTO creationMessage(User createdUser) {
        return returnMessage(createdUser, "created");
    }

    public static MessageDTO updatedMessage(User updatedUser) {
        return returnMessage(updatedUser, "updated");
    }

    private static MessageDTO returnMessage(User updatedUser, String action) {

        String email = updatedUser.getEmail();
        Long id = updatedUser.getId();

        String message = String.format("User %s with ID %s was successfully %s", email, id, action);

        return MessageDTO.builder()
                .message(message)
                .build();
    }

}
