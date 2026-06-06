package com.example.social_media.Service.impl;

import com.example.social_media.Entity.Follow;
import com.example.social_media.Entity.User;
import com.example.social_media.Repository.FollowRepository;
import com.example.social_media.Repository.UserRepository;
import com.example.social_media.Service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Override
    public String followUser(Long userId) {

        User currentUser = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));        User targetUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Target user not found"));

        if (currentUser.getId() == targetUser.getId())  {
            throw new RuntimeException("You cannot follow yourself");
        }

        Follow existingFollow = followRepository
                .findByFollowerAndFollowing(currentUser, targetUser)
                .orElse(null);

        // Unfollow
        if (existingFollow != null) {
            followRepository.delete(existingFollow);
            return "Unfollowed successfully";
        }

        // Follow
        Follow follow = Follow.builder()
                .follower(currentUser)
                .following(targetUser)
                .build();

        followRepository.save(follow);

        return "Followed successfully";
    }

    @Override
    public List<User> getFollowers(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return followRepository.findByFollowing(user)
                .stream()
                .map(Follow::getFollower)
                .toList();
    }

    @Override
    public List<User> getFollowing(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return followRepository.findByFollower(user)
                .stream()
                .map(Follow::getFollowing)
                .toList();
    }
}
