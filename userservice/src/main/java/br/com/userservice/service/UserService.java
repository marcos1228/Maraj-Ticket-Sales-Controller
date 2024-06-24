package br.com.userservice.service;

import br.com.userservice.model.domain.User;
import br.com.userservice.model.dto.UserDto;
import br.com.userservice.model.dto.UserRegistrationDto;
import br.com.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto registerUser(UserRegistrationDto userRegistrationDto) {
        if (userRepository.findByUsername(userRegistrationDto.getUsername()).isPresent() ||
                userRepository.findByEmail(userRegistrationDto.getEmail()).isPresent()) {
            return null;
        }

        User user = mapToUser(userRegistrationDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return mapToUserDto(savedUser);
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(this::mapToUserDto).orElse(null);
    }

    private User mapToUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(userRegistrationDto.getPassword());
        user.setEmail(userRegistrationDto.getEmail());
        return user;
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}