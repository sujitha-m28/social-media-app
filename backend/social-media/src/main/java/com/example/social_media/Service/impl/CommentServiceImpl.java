package com.example.social_media.Service.impl;

import com.example.social_media.DTO.CommentRequest;
import com.example.social_media.Entity.Comment;
import com.example.social_media.Entity.Post;
import com.example.social_media.Repository.CommentRepository;
import com.example.social_media.Repository.PostRepository;
import com.example.social_media.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Comment addComment(Long postId, Long userId, CommentRequest request) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = Comment.builder()
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .userId(userId)
                .post(post)
                .build();

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return commentRepository.findByPost(post);
    }
}
