package com.bcs.battle_command_system.team.dto;

import com.bcs.battle_command_system.team.entity.Team;

import java.time.LocalDateTime;

public record TeamDto(
        Long id,
        String name,
        String description,
        Double latitude,
        Double longitude,
        String color,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TeamDto from(Team team) {

        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getDescription(),
                team.getLatitude(),
                team.getLongitude(),
                team.getColor(),
                team.getCreatedAt(),
                team.getUpdatedAt()
        );
    }
}