package com.example.social_media.Service;

import com.example.social_media.Entity.User;

import java.util.List;

public interface FollowService {
    String followUser(Long userId);

    List<User> getFollowers(Long userId);

    List<User> getFollowing(Long userId);
}
