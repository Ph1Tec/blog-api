package com.blog.blogdb.dto;

import com.blog.blogdb.model.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostResponseDTO {
    private Long id;
    private String  title;
    private String  content;
    private LocalDateTime createdAt;
    private UserResponseDTO author;

    public PostResponseDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.author = new UserResponseDTO(post.getAuthor());
    }
}
