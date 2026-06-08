package com.example.social_media.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResponse {
    private String fileName;
    private String fileUrl;
}
