package org.example.pard.Image.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO {
    private Long imageId;
    private String filePath;
}
