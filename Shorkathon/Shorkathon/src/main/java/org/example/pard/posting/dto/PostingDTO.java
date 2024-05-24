package org.example.pard.posting.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.example.pard.Image.entity.Image;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostingDTO {    @Setter
@Getter
public static class Create{
    private String postContent;
    private String postTitle;
    private int feeling;
}
    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long postId;
        private int photoId;
        private String postContent;
        private String postTitle;
        private int feeling;
        private Timestamp postedTime;
        private Image image;

        // private List<CommentDTO.Read> commentList;

        public Read(Long postId, int photoId, String postContent, String postTitle, int feeling, Timestamp postedTime) {
            this.postId = postId;
            this.photoId = photoId;
            this.postContent = postContent;
            this.postTitle = postTitle;
            this.feeling = feeling;
            this.postedTime = postedTime;
        }
    }
}
