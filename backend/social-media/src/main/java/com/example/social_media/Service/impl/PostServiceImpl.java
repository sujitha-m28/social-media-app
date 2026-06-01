package com.example.social_media.Service.impl;

import com.example.social_media.DTO.PostRequest;
import com.example.social_media.Entity.Post;
import com.example.social_media.Repository.PostRepository;
import com.example.social_media.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post createPost(PostRequest request) {

        Post post = Post.builder()
                .content(request.getContent())
                .imageUrl(request.getImageUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {

        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public Post updatePost(Long id, PostRequest request) {

        Post post = getPostById(id);

        post.setContent(request.getContent());
        post.setImageUrl(request.getImageUrl());
        post.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {

        Post post = getPostById(id);

        postRepository.delete(post);
    }
}
