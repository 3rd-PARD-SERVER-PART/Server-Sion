package org.example.pard.comment.controller;

import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.comment.entity.Comment;
import org.example.pard.comment.service.CommentService;
import org.example.pard.posting.dto.PostingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/get/{id}")
    public ResponseEntity<CommentDTO.Read> getComments(@PathVariable Long id) {
        CommentDTO.Read comment = commentService.getComments(id);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<String> createComment(@PathVariable Long postId, @RequestBody CommentDTO.Create dto) {
        commentService.addComment(dto, postId);
        return ResponseEntity.ok("Comment added");
    }

}
