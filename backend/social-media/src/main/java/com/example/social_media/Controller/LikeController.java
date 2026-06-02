package com.example.social_media.Controller;

import com.example.social_media.Service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{id}/like")
    public String likePost(@PathVariable Long id) {

        Long userId = 1L;

        return likeService.likePost(id, userId);
    }

    @DeleteMapping("/{id}/unlike")
    public String unlikePost(@PathVariable Long id) {

        Long userId = 1L;

        return likeService.unlikePost(id, userId);
    }
}
