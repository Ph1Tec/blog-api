package com.blog.blogdb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentCreateDTO {
    private String content;
    private Long postId;
    private Long authorId;
}
