package org.example.pard.Image.controller;

import org.example.pard.Image.entity.Image;
import org.example.pard.Image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
     */

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Long id) {
        try {
            String filePath = imageService.getFilePathById(id);
            Resource resource = imageService.getImageResource(filePath);
            String contentType = imageService.getContentType(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
