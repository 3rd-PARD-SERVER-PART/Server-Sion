package org.example.pard.comment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.posting.entity.Posting;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posting posting;
}
