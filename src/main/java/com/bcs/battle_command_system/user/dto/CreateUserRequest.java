package com.bcs.battle_command_system.user.dto;

import com.bcs.battle_command_system.role.entity.Role;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        Role role,
        Long teamId
) {
}