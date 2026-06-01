package com.example.social_media.Service;

import com.example.social_media.DTO.PostRequest;
import com.example.social_media.Entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostRequest request);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post updatePost(Long id, PostRequest request);

    void deletePost(Long id);
}
