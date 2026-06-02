package com.example.social_media.Service;

public interface LikeService {
    String likePost(Long postId, Long userId);

    String unlikePost(Long postId, Long userId);
}
