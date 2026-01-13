package com.brown.user_auth_api.controller;

import com.brown.user_auth_api.dto.UserRegistrationDto;
import com.brown.user_auth_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

     @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String RegisterUser(@RequestBody UserRegistrationDto registrationDto){
        System.out.println("Received User Registration Request" + registrationDto.getUsername());
        return userService.registerUser(registrationDto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, String email) {
        System.out.println("Received request to delete user with id: " + id);
        System.out.println("Received request to delete user with email: " + email);
        return userService.deleteUser(id, email);

    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRegistrationDto registrationDto) {
        System.out.println("Received request to update user with id: " + id);
        return userService.UpdateUser(id, registrationDto);
     }
}
