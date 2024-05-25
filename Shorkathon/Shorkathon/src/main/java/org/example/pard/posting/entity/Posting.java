package org.example.pard.posting.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.Image.entity.Image;
import org.example.pard.posting.dto.PostingDTO;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postContent;
    private int feeling;
    @CreationTimestamp // Automatically set the current timestamp
    private Timestamp postedTime;

    @OneToOne
    private Image image;
/*
    // Assuming you have a Comment entity for commentList
    @OneToOne(mappedBy = "post_id")
    private Comment comment;
*/
    public static Posting toEntity(PostingDTO.Create dto, Image image) {
        return Posting.builder()
                .postContent(dto.getPostContent())
                .postTitle(dto.getPostTitle())
                .feeling(dto.getFeeling())
                .image(image)
                .build();
    }

}
