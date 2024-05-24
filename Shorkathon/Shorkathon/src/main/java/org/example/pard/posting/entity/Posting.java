package org.example.pard.posting.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.Image.entity.Image;
import org.example.pard.comment.entity.Comment;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private Long photoId;
    private String postContent;
    private String postTitle;
    private int feeling;
    @CreationTimestamp // Automatically set the current timestamp
    private Timestamp postedTime;

    @OneToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId")
    private Image image;

    // Assuming you have a Comment entity for commentList
    @OneToMany(mappedBy = "posting")
    private List<Comment> commentList;

    public static Posting toEntity(PostingDTO.Create dto) {
        return Posting.builder()
                .postContent(dto.getPostContent())
                .postTitle(dto.getPostTitle())
                .feeling(dto.getFeeling())
                .build();
    }
}
