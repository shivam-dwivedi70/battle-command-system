package com.bcs.battle_command_system.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcs.battle_command_system.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	  Optional<User> findByEmail(String email);

}
