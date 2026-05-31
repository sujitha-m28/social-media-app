package com.example.social_media.Service;

import com.example.social_media.DTO.UpdateProfileRequest;
import com.example.social_media.Entity.User;

public interface UserService {
    User getUserById(Long id);
    User updateProfile(Long id, UpdateProfileRequest request);
}
