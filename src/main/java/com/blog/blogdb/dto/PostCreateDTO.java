package com.blog.blogdb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostCreateDTO {
    private String title;
    private String content;
    private Long authorId;
}
