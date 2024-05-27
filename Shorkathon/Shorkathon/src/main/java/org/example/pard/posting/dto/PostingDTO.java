package org.example.pard.posting.dto;

import lombok.*;
import org.example.pard.posting.entity.Posting;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class PostingDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create {
        private String postContent;
        private int feeling;
        private String postDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Comment {
        private Long postId;
        private Long commentId;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @Builder
    public static class Read {
        private Long postId;
        private String postContent;
        private int feeling;
        private String postDate;
        private Long imageId;

        public Read(Long postId, String postContent, int feeling, String postDate, Long imageId) {
            this.postId = postId;
            this.postContent = postContent;
            this.feeling = feeling;
            this.postDate = postDate;
            this.imageId = imageId;
        }

        public static Read fromEntity(Posting posting) {
            return new Read(
                    posting.getPostId(),
                    posting.getPostContent(),
                    posting.getFeeling(),
                    posting.getPostDate(),
                    posting.getImage().getImageId()
            );
        }
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @Builder
    public static class ReadComment {
        private Long postId;
        private String postContent;
        private int feeling;
        private String postDate;
        private Long imageId;
        private Long commentId;
        private String commentContent;

        public ReadComment(Long postId, String postContent, int feeling, String postDate, Long imageId, Long commentId, String commentContent) {
            this.postId = postId;
            this.postContent = postContent;
            this.feeling = feeling;
            this.postDate = postDate;
            this.imageId = imageId;
            this.commentId = commentId;
            this.commentContent = commentContent;
        }

        public static ReadComment fromEntity(Posting posting) {
            org.example.pard.comment.entity.Comment comment = posting.getComment();
            return new ReadComment(
                    posting.getPostId(),
                    posting.getPostContent(),
                    posting.getFeeling(),
                    posting.getPostDate(),
                    posting.getImage() != null ? posting.getImage().getImageId() : null,
                    comment != null ? comment.getCommentId() : null,
                    comment != null ? comment.getCommentContent() : null
            );
        }
    }
}
