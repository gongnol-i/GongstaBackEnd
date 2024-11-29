package com.gongsta.gongstabackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    private String imageUrl;
    private String caption;
    private String username;
}
