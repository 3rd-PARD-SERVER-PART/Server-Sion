package org.example.pard.Image.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.Image.dto.ImageDTO;
import org.example.pard.posting.entity.Posting;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String filePath;


//    @OneToOne(mappedBy = "image")
//    @JoinColumn(name = "post_id")
//    private Posting posting;

/*
    public static Image toEntity (ImageDTO.Create dto){
        return Image.builder()
                .filePath(dto.getFilePath())
                .posting(dto.getPosting())
                .build();
    }

 */

}
