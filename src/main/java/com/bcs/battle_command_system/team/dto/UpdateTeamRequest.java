package com.bcs.battle_command_system.team.dto;

public record UpdateTeamRequest(
        String name,
        String description,
        Double latitude,
        Double longitude,
        String color
) {
}
