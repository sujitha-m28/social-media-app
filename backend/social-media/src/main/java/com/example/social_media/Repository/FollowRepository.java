package com.example.social_media.Repository;

import com.example.social_media.Entity.Follow;
import com.example.social_media.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerAndFollowing(User follower, User following);

    List<Follow> findByFollowing(User following);

    List<Follow> findByFollower(User follower);
}
