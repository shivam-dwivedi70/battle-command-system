package com.bcs.battle_command_system.user.dto;

import com.bcs.battle_command_system.role.entity.Role;

public record UpdateUserRequest(
        String name,
        String email,
        Role role,
        Long teamId
) {
}
