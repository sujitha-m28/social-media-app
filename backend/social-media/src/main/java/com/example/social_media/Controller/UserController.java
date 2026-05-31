package com.example.social_media.Controller;

import com.example.social_media.DTO.UpdateProfileRequest;
import com.example.social_media.Entity.User;
import com.example.social_media.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // GET USER PROFILE
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    // UPDATE USER PROFILE
    @PutMapping("/update/{id}")
    public User updateProfile(
            @PathVariable Long id,
            @RequestBody UpdateProfileRequest request) {
        return userService.updateProfile(id, request);
    }

    }

