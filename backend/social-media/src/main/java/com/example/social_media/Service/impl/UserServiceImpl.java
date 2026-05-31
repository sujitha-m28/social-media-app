package com.example.social_media.Service.impl;

import com.example.social_media.DTO.UpdateProfileRequest;
import com.example.social_media.Entity.User;
import com.example.social_media.Repository.UserRepository;
import com.example.social_media.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateProfile(Long id, UpdateProfileRequest request) {

        User user = getUserById(id);

        user.setBio(request.getBio());
        user.setProfileImage(request.getProfileImage());

        return userRepository.save(user);
    }
}
