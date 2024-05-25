package org.example.pard.Image.dto;

import lombok.*;
import org.example.pard.posting.entity.Posting;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ImageDTO {
    @Setter
    @Getter
    public class Create{
        private String filePath;
        private Long imageId;

    }
}
