package com.bcs.battle_command_system.team.service;

import com.bcs.battle_command_system.team.dto.CreateTeamRequest;
import com.bcs.battle_command_system.team.dto.TeamDto;
import com.bcs.battle_command_system.team.dto.UpdateTeamRequest;
import com.bcs.battle_command_system.team.entity.Team;
import com.bcs.battle_command_system.team.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // CREATE TEAM
    public TeamDto createTeam(CreateTeamRequest request) {

        Team team = new Team();

        team.setName(request.name());
        team.setDescription(request.description());
        team.setLatitude(request.latitude());
        team.setLongitude(request.longitude());
        team.setColor(request.color());

        Team savedTeam = teamRepository.save(team);

        return TeamDto.from(savedTeam);
    }

    // GET TEAM BY ID
    public TeamDto getTeamById(Long id) {

        Team team = teamRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Team not found"));

        return TeamDto.from(team);
    }

    // GET ALL TEAMS
    public List<TeamDto> getAllTeams() {

        return teamRepository.findAll()
                .stream()
                .map(TeamDto::from)
                .toList();
    }

    // UPDATE TEAM
    public TeamDto updateTeam(
            Long id,
            UpdateTeamRequest request) {

        Team team = teamRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Team not found"));

        team.setName(request.name());
        team.setDescription(request.description());
        team.setLatitude(request.latitude());
        team.setLongitude(request.longitude());
        team.setColor(request.color());

        Team updatedTeam = teamRepository.save(team);

        return TeamDto.from(updatedTeam);
    }

    // DELETE TEAM
    public void deleteTeam(Long id) {

        if (!teamRepository.existsById(id)) {
            throw new RuntimeException("Team not found");
        }

        teamRepository.deleteById(id);
    }
}
