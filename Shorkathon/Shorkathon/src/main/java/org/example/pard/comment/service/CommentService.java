package org.example.pard.comment.service;

import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.comment.entity.Comment;
import org.example.pard.comment.repository.CommentRepository;
import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.posting.entity.Posting;
import org.example.pard.posting.repository.PostingRepository;
import org.example.pard.posting.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostingRepository postingRepository;


    @Transactional
    public Comment addComment(CommentDTO.Create dto, Long postId) {
        Optional<Posting> postingOptional = postingRepository.findById(postId);
        if (postingOptional.isPresent()) {
            Posting posting = postingOptional.get();
            Comment comment = Comment.toEntity(dto);
            posting.setComment(comment); // Set comment to posting
            commentRepository.save(comment); // Save the comment
            postingRepository.save(posting); // Save the posting to update the relationship
            return comment;
        } else {
            throw new IllegalArgumentException("Invalid postId");
        }
    }

    public CommentDTO.Read getComments(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment == null) {
            return null;
        }
        return CommentDTO.Read.fromEntity(comment.get());
    }
}
