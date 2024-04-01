package org.africalib.gallery.secondassignment.user;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    private Integer id;
    private String name;
    private Integer price;
}
