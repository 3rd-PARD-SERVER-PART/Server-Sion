package org.example.pard.comment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.comment.dto.CommentDTO;
import org.example.pard.posting.entity.Posting;
import org.hibernate.mapping.ToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;


    @OneToOne
    @JoinColumn(name = "commentId") // db연결 위한 파트
    private Posting posting;

    public static Comment toEntity(CommentDTO.Create dto) {
        return Comment.builder()
                .commentContent(dto.getCommentContent())
                .build();
    }

}
