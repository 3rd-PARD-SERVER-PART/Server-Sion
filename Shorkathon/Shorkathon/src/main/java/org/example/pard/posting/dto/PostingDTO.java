package org.example.pard.posting.dto;

import lombok.*;
import org.example.pard.posting.entity.Posting;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

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


}
