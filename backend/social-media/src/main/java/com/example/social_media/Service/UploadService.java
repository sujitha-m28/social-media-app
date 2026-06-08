package com.example.social_media.Service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String uploadProfileImage(Long userId, MultipartFile file);

    String uploadPostImage(Long postId, MultipartFile file);
}
