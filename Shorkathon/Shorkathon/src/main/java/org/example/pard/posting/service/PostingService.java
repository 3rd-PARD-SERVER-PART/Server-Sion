package org.example.pard.posting.service;

import java.util.List;
import java.util.Random;

import lombok.RequiredArgsConstructor;
import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.posting.dto.GetPostingDTO;
import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.Image.entity.Image;
import org.example.pard.posting.entity.Posting;
import org.example.pard.Image.repository.ImageRepository;
import org.example.pard.posting.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    @Autowired
    private ImageRepository imageRepository;

    public void createPost(PostingDTO.Create dto) {
        PostingRepository.save(Posting.toEntity(dto));
    }
    public PostingDTO getRandomPost() {
    }

    public PostingDTO getPostWithComments(Long postId) {
        Posting post = postingRepository.findById(postId).orElse(null);
        if (post != null) {
            return PostingDTO.builder()
                    .postId(post.getPostId())
                    .photoId(post.getPhotoId())
                    .postContent(post.getPostContent())
                    .postTitle(post.getPostTitle())
                    .feeling(post.getFeeling())
                    .postedTime(post.getPostedTime())
                    .imageId(post.getImage().getImageId())
                    .commentList(post.getCommentList().stream()
                            .map(comment -> CommentDTO.builder()
                                    .commentId(comment.getCommentId())
                                    .commentContent(comment.getCommentContent())
                                    .postId(comment.getPosting().getPostId())
                                    .build())
                            .collect(Collectors.toList()))
                    .build();
        }
        return null;
    }
}