package com.bcs.battle_command_system.user.service;

import com.bcs.battle_command_system.role.entity.Role;
import com.bcs.battle_command_system.team.entity.Team;
import com.bcs.battle_command_system.user.dto.CreateUserRequest;
import com.bcs.battle_command_system.user.dto.UpdateUserRequest;
import com.bcs.battle_command_system.user.dto.UserDto;
import com.bcs.battle_command_system.user.entity.User;
import com.bcs.battle_command_system.user.repository.UserRepository;
import com.bcs.battle_command_system.team.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public UserService(
            UserRepository userRepository,
            TeamRepository teamRepository) {

        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }


    // CREATE USER
    public UserDto createUser(CreateUserRequest request) {

        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(request.role());

        if (request.teamId() != null) {

            Team team = teamRepository.findById(request.teamId())
                    .orElseThrow(() ->
                            new RuntimeException("Team not found"));

            user.setTeam(team);
        }

        User savedUser = userRepository.save(user);

        return UserDto.from(savedUser);
    }


    // GET USER BY ID 
    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return UserDto.from(user);
    }


	    // GET ALL USERS
	    public List<UserDto> getAllUsers() {
	
	        return userRepository.findAll()
	                .stream()
	                .map(UserDto::from)
	                .toList();
	    }


    // UPDATE USER
    public UserDto updateUser(
            Long id,
            UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setName(request.name());
        user.setEmail(request.email());
        user.setRole(request.role());

        if (request.teamId() != null) {

            Team team = teamRepository.findById(request.teamId())
                    .orElseThrow(() ->
                            new RuntimeException("Team not found"));

            user.setTeam(team);

        } else {

            user.setTeam(null);
        }

        User updatedUser = userRepository.save(user);

        return UserDto.from(updatedUser);
    }


    // DELETE USER
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}
