package br.com.userservice.controller;

import br.com.userservice.service.UserService;
import br.com.userservice.model.dto.UserDto;
import br.com.userservice.model.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserDto userDto = userService.registerUser(userRegistrationDto);
        if (userDto == null) {
            return ResponseEntity.badRequest().body("Username or Email already exists");
        }
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        UserDto userDto = userService.getUserByUsername(username);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }
}
