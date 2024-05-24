package org.example.pard.comment.controller;

import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO addedComment = commentService.addComment(commentDTO);
        if (addedComment != null) {
            return ResponseEntity.ok(addedComment);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<CommentDTO> getComment(@RequestParam("commentId") Long commentId) {
        CommentDTO comment = commentService.getComments(commentId);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
