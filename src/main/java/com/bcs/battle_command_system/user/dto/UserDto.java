package com.bcs.battle_command_system.user.dto;

import java.time.LocalDateTime;

import com.bcs.battle_command_system.role.entity.Role;
import com.bcs.battle_command_system.user.entity.User;

public record UserDto(
        Long id,
        String name,
        String email,
        Role role,
        Long teamId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static UserDto from(User user) {

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getTeam() != null
                        ? user.getTeam().getId()
                        : null,
                        user.getCreatedAt(),
                        user.getUpdatedAt()
        );
    }
}
