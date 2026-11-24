package com.bcs.battle_command_system.team.controller;

import com.bcs.battle_command_system.team.dto.CreateTeamRequest;
import com.bcs.battle_command_system.team.dto.TeamDto;
import com.bcs.battle_command_system.team.dto.UpdateTeamRequest;
import com.bcs.battle_command_system.team.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // CREATE TEAM
    @PostMapping
    public TeamDto createTeam(
            @RequestBody CreateTeamRequest request) {

        return teamService.createTeam(request);
    }

    // GET TEAM BY ID
    @GetMapping("/{id}")
    public TeamDto getTeamById(
            @PathVariable Long id) {

        return teamService.getTeamById(id);
    }

    // GET ALL TEAMS
    @GetMapping
    public List<TeamDto> getAllTeams() {

        return teamService.getAllTeams();
    }

    // UPDATE TEAM
    @PutMapping("/{id}")
    public TeamDto updateTeam(
            @PathVariable Long id,
            @RequestBody UpdateTeamRequest request) {

        return teamService.updateTeam(id, request);
    }

    // DELETE TEAM
    @DeleteMapping("/{id}")
    public void deleteTeam(
            @PathVariable Long id) {

        teamService.deleteTeam(id);
    }
}
