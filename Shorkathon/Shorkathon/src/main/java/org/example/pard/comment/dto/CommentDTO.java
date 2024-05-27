package org.example.pard.comment.dto;

import lombok.*;
import org.example.pard.comment.entity.Comment;


@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class CommentDTO {



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        private String commentContent;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Read {
        private String commentContent;

        public static CommentDTO.Read fromEntity(Comment comment) {
            return new CommentDTO.Read(comment.getCommentContent());
        }
    }
}
