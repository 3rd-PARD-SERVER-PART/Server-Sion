package org.example.pard.comment.service;

import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.comment.entity.Comment;
import org.example.pard.posting.entity.Posting;
import org.example.pard.comment.repository.CommentRepository;
import org.example.pard.posting.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostingRepository postingRepository;

    public CommentDTO addComment(CommentDTO commentDTO) {
        Posting posting = postingRepository.findById(commentDTO.getPostId()).orElse(null);
        if (posting == null) {
            return null;
        }

        Comment comment = Comment.builder()
                .commentContent(commentDTO.getCommentContent())
                .posting(posting)
                .build();

        Comment savedComment = commentRepository.save(comment);

        return CommentDTO.builder()
                .commentId(savedComment.getCommentId())
                .commentContent(savedComment.getCommentContent())
                .postId(savedComment.getPosting().getPostId())
                .build();
    }
    public CommentDTO getComments(Long commentId) {
        return commentRepository.findById(commentId)
                .map(comment -> CommentDTO.builder()
                        .commentId(comment.getCommentId())
                        .commentContent(comment.getCommentContent())
                        .postId(comment.getPosting().getPostId())
                        .build())
                .orElse(null); // Return null if comment is not found
    }
}

