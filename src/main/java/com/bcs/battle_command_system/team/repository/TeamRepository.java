package com.bcs.battle_command_system.team.repository;

import com.bcs.battle_command_system.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
