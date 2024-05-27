package org.example.pard.posting.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.Image.entity.Image;
import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.posting.entity.Posting;
import org.example.pard.posting.repository.PostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;



    public void createPost(PostingDTO.Create dto, Image image) {
        postingRepository.save(Posting.toEntity(dto, image));
    }

    public PostingDTO.ReadComment getPost(Long postId) {
        Posting posting = postingRepository.findById(postId).orElse(null);
        if (posting == null) {
            return null;
        }
        return PostingDTO.ReadComment.fromEntity(posting);
    }


    public PostingDTO.Read getRandomPost() {
        List<Posting> allPostings = postingRepository.findAll();
        if (allPostings.isEmpty()) {
            return null; // Or perform exception handling
        }

        // Filter postings with null comment_id
        List<Posting> postingsWithNullCommentId = allPostings.stream()
                .filter(posting -> posting.getComment() == null || posting.getComment().getCommentId() == null)
                .collect(Collectors.toList());

        if (postingsWithNullCommentId.isEmpty()) {
            return null; // Or perform exception handling
        }

        Random random = new Random();
        int randomIndex = random.nextInt(postingsWithNullCommentId.size());
        Posting randomPosting = postingsWithNullCommentId.get(randomIndex);
        return PostingDTO.Read.fromEntity(randomPosting);
    }





}
