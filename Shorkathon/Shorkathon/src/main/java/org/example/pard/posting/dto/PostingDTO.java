package org.example.pard.posting.dto;

import lombok.*;
import org.example.pard.posting.entity.Posting;
import org.springframework.web.multipart.MultipartFile;

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
        private String postTitle;
        private int feeling;
        private time postedTime;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Read {
        private Long postId;
        private String postContent;
        private String postTitle;
        private int feeling;
        private Long imageId;

        public static Read fromEntity(Posting posting) {
            return new Read(
                    posting.getPostId(),
                    posting.getPostContent(),
                    posting.getPostTitle(),
                    posting.getFeeling(),
                    posting.getImage().getImageId()
            );
        }
    }


}
