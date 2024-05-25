package org.example.pard.posting.controller;

import org.example.pard.Image.service.ImageService;

import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.posting.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/postings")
public class PostingController {

    @Autowired
    private PostingService postingService;


    @Autowired
    private ImageService imageService;
    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestPart PostingDTO.Create postingDTO,
                                             @RequestPart MultipartFile image
                                             ) {
        Long imageId = imageService.uploadImage(image).getBody();
        postingService.createPost(postingDTO, imageService.findById(imageId) );
        return ResponseEntity.ok("추가됨");
    }

    @GetMapping("/random")
    public ResponseEntity<PostingDTO.Read> getRandomPost() {
        PostingDTO.Read randomPost = postingService.getRandomPost();
        if (randomPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(randomPost);
    }

}
