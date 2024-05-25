package org.example.pard.Image.controller;

import org.example.pard.Image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadImage(@RequestBody MultipartFile image) {
        return imageService.uploadImage(image);
    }
/*
    @GetMapping("/get")
    public ResponseEntity<Long> getPostId() {
        Long imageId = imageService.getPostId();
        if (imageId != null) {
            return ResponseEntity.ok(imageId);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Long> getPostImage(@PathVariable Long postId) {
        Long imageId = imageService.getPostImage(postId).getImageId();
        if (imageId != null) {
            return ResponseEntity.ok(imageId);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

 */
}
