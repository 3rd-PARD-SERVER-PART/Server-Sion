package org.example.pard.posting.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.Image.entity.Image;
import org.example.pard.Image.repository.ImageRepository;
import org.example.pard.Image.service.ImageService;
import org.example.pard.posting.dto.PostingDTO;
import org.example.pard.posting.entity.Posting;
import org.example.pard.posting.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final ImageService imageService;
    private final ImageRepository imageRepository;


    public void createPost(PostingDTO.Create dto, Image image) {
        postingRepository.save(Posting.toEntity(dto, image));
    }

    public PostingDTO.Read getRandomPost() {
        List<Posting> allPostings = postingRepository.findAll();
        if (allPostings.isEmpty()) {
            return null; // 혹은 예외 처리를 수행할 수 있습니다.
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allPostings.size());
        Posting randomPosting = allPostings.get(randomIndex);
        return PostingDTO.Read.fromEntity(randomPosting);
    }



}
