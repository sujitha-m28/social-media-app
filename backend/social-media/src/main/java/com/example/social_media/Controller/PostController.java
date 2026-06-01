package com.example.social_media.Controller;

import com.example.social_media.DTO.PostRequest;
import com.example.social_media.Entity.Post;
import com.example.social_media.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody PostRequest request) {

        return postService.createPost(request);
    }

    @GetMapping
    public List<Post> getAllPosts() {

        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {

        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody PostRequest request) {

        return postService.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return "Post deleted successfully";
    }

}
