package com.example.social_media.Service.impl;

import com.example.social_media.Entity.Like;
import com.example.social_media.Entity.Post;
import com.example.social_media.Repository.LikeRepository;
import com.example.social_media.Repository.PostRepository;
import com.example.social_media.Service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    @Override
    public String likePost(Long postId, Long userId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        boolean alreadyLiked = likeRepository
                .findByUserIdAndPost(userId, post)
                .isPresent();

        if (alreadyLiked) {
            return "Post already liked";
        }

        Like like = Like.builder()
                .userId(userId)
                .post(post)
                .build();

        likeRepository.save(like);

        return "Post liked successfully";
    }

    @Override
    public String unlikePost(Long postId, Long userId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Like like = likeRepository.findByUserIdAndPost(userId, post)
                .orElseThrow(() -> new RuntimeException("Like not found"));

        likeRepository.delete(like);

        return "Post unliked successfully";
    }
}