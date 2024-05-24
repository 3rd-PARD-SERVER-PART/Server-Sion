package org.example.pard.comment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long commentId;
    private String commentContent;
    private Long postId;
}

