package com.bcs.battle_command_system.team.dto;

public record CreateTeamRequest(
        String name,
        String description,
        Double latitude,
        Double longitude,
        String color
) {
}
