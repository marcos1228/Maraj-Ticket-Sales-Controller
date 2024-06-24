package br.com.userservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    @NotEmpty
    @Size(min = 4, max = 20)
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 6)
    private String password;

    public @NotEmpty @Size(min = 4, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty @Size(min = 4, max = 20) String username) {
        this.username = username;
    }

    public @NotEmpty @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public @NotEmpty @Size(min = 6) String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty @Size(min = 6) String password) {
        this.password = password;
    }
}
