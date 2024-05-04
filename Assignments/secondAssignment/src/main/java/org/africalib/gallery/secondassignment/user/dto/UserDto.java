package org.africalib.gallery.secondassignment.menu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private Integer id;
    private String name;
    private Integer price;
}
