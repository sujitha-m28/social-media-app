package com.example.social_media.Repository;

import com.example.social_media.Entity.Like;
import com.example.social_media.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndPost(Long userId, Post post);

    long countByPost(Post post);
}
