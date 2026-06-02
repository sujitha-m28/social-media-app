package com.example.social_media.Service;

import com.example.social_media.DTO.CommentRequest;
import com.example.social_media.Entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Long postId, Long userId, CommentRequest request);

    List<Comment> getComments(Long postId);
}
