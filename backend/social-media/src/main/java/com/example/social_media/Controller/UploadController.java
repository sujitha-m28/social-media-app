package com.example.social_media.Controller;

import com.example.social_media.DTO.UploadResponse;
import com.example.social_media.Service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class UploadController {
    private final UploadService uploadService;

    @PostMapping("/profile/{userId}")
    public UploadResponse uploadProfileImage(
            @PathVariable Long userId,
            @RequestParam("file") MultipartFile file
    ) {

        String url = uploadService.uploadProfileImage(userId, file);

        return new UploadResponse(
                file.getOriginalFilename(),
                url
        );
    }

    @PostMapping("/post/{postId}")
    public UploadResponse uploadPostImage(
            @PathVariable Long postId,
            @RequestParam("file") MultipartFile file
    ) {

        String url = uploadService.uploadPostImage(postId, file);

        return new UploadResponse(
                file.getOriginalFilename(),
                url
        );
    }
}
