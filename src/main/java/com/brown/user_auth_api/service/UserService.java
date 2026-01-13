package com.brown.user_auth_api.service;

import com.brown.user_auth_api.dto.UserRegistrationDto;
import com.brown.user_auth_api.models.NewUser;
import com.brown.user_auth_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String registerUser(UserRegistrationDto registrationDto) {
        NewUser user = new NewUser();
        user.setUsername(registrationDto.getUsername());
        user.setSurname(registrationDto.getSurname());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setAddress(registrationDto.getAddress());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        userRepository.save(user);
        return "Üser Successfully Registered";
    }

    @DeleteMapping
    @Transactional
    public String deleteUser(@NotNull Long id, String email) {
        if (!userRepository.existsById(id)) {
            return "User with id " + id + " does not exist.";
        }
        if (!userRepository.existsByEmail(email)){
            return "User with email " + email + " does not exist.";
        }
        userRepository.deleteByEmail(email);
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted.";

    }
    public String UpdateUser(@NotNull Long id, UserRegistrationDto registrationDto) {
        NewUser user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "User with id " + id + " does not exist.";
        }
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        userRepository.save(user);
        return "User with id " + id + " has been updated.";
    }
}

