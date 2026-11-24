package com.bcs.battle_command_system.user.contoller;

import com.bcs.battle_command_system.user.dto.CreateUserRequest;
import com.bcs.battle_command_system.user.dto.UpdateUserRequest;
import com.bcs.battle_command_system.user.dto.UserDto;
import com.bcs.battle_command_system.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(
            @RequestBody CreateUserRequest request) {

        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(
            @PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {

        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);
    }
}