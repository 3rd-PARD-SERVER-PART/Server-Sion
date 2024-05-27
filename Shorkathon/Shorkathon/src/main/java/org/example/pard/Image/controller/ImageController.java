package org.example.pard.Image.controller;

import org.example.pard.Image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadImage(@RequestBody MultipartFile image) {
        return imageService.uploadImage(image);
    }



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

    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getAllImages() {
        try {
            List<String> filePaths = imageService.getAllImageFilePaths();
            List<Resource> resources = imageService.getAllImages(filePaths);
            List<String> contentTypes = imageService.getAllContentTypes(filePaths);

            if (contentTypes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            // Check if all content types are the same
            String contentType = contentTypes.get(0);
            boolean allSameContentType = contentTypes.stream().allMatch(type -> type.equals(contentTypes));

            // If all content types are the same, use that content type; otherwise, use "application/octet-stream"
            if (!allSameContentType) {
                contentType = "application/octet-stream";
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            // Add content disposition headers for each resource
            for (int i = 0; i < resources.size(); i++) {
                Resource resource = resources.get(i);
                String fileName = resource.getFilename() != null ? resource.getFilename() : "image_" + i;
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"");
            }

            return new ResponseEntity<>(resources, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
