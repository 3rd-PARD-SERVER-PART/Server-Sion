package org.example.pard.posting.controller;

import org.example.pard.posting.dto.GetPostingDTO;
import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.posting.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/posts")
public class PostingController {

    @Autowired
    private PostingService postingService;

    @PostMapping("/create")
    public String createPost(@RequestBody PostingDTO.Create postingDTO) {
        postingService.createPost(postingDTO);
        return "추가됨";
    }
    @GetMapping("/get")
    public ResponseEntity<PostingDTO> getRandomPost() {
        PostingDTO randomPost = postingService.getRandomPost();
        if (randomPost != null) {
            return ResponseEntity.ok(randomPost);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/get/{postId}")
    public ResponseEntity<PostingDTO> getPost(@PathVariable("postId") Long postId) {
        PostingDTO post = postingService.getPostWithComments(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
