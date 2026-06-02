package com.example.social_media.Repository;

import com.example.social_media.Entity.Comment;
import com.example.social_media.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByPost(Post post);
}
