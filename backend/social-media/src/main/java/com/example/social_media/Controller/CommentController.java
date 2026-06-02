package com.example.social_media.Controller;

import com.example.social_media.DTO.CommentRequest;
import com.example.social_media.Entity.Comment;
import com.example.social_media.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}/comment")
    public Comment addComment(
            @PathVariable Long id,
            @RequestBody CommentRequest request
    ) {

        Long userId = 1L;

        return commentService.addComment(id, userId, request);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getComments(@PathVariable Long id) {

        return commentService.getComments(id);
    }
}
