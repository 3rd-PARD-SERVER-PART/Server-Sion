package org.example.pard.Image.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pard.posting.entity.Posting;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;
    private String filePath;

    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posting posting;
}
