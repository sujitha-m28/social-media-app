package com.example.social_media.Service.impl;

import com.example.social_media.Entity.Post;
import com.example.social_media.Entity.User;
import com.example.social_media.Repository.PostRepository;
import com.example.social_media.Repository.UserRepository;
import com.example.social_media.Service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String uploadProfileImage(Long userId, MultipartFile file) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String imageUrl = saveFile(file);

        user.setProfileImage(imageUrl);

        userRepository.save(user);

        return imageUrl;
    }

    @Override
    public String uploadPostImage(Long postId, MultipartFile file) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        String imageUrl = saveFile(file);

        post.setImageUrl(imageUrl);

        postRepository.save(post);

        return imageUrl;
    }

    private String saveFile(MultipartFile file) {

        try {

            String originalFileName = file.getOriginalFilename();

            String fileName = UUID.randomUUID() + "_" + originalFileName;

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return "/uploads/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("File upload failed");
        }
    }
}
