package com.example.social_media.Controller;

import com.example.social_media.Entity.User;
import com.example.social_media.Service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/{userId}")
    public String followUser(@PathVariable Long userId) {
        return followService.followUser(userId);
    }

    @GetMapping("/followers/{userId}")
    public List<User> getFollowers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }

    @GetMapping("/following/{userId}")
    public List<User> getFollowing(@PathVariable Long userId) {
        return followService.getFollowing(userId);
    }
}