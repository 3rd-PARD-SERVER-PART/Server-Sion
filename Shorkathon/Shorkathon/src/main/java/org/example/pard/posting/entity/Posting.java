package org.example.pard.posting.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.Image.entity.Image;
import org.example.pard.comment.entity.Comment;
import org.example.pard.posting.dto.PostingDTO;
import org.hibernate.annotations.CreationTimestamp;


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
    private String postDate;

    @OneToOne
    private Image image;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comment_id", referencedColumnName = "commentId")
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
        comment.setPosting(this);
    }
    public static Posting toEntity(PostingDTO.Create dto, Image image) {
        return Posting.builder()
                .postContent(dto.getPostContent())
                .postDate(dto.getPostDate())
                .feeling(dto.getFeeling())
                .image(image)
                .build();
    }

}
