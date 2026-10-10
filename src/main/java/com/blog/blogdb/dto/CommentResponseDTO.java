package com.blog.blogdb.dto;

import com.blog.blogdb.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentResponseDTO {
    private Long id;
    private String  content;
    private LocalDateTime createdAt;
    private Long postId;
    private UserResponseDTO author;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.postId =   comment.getPost().getId();
        this.author = new UserResponseDTO(comment.getAuthor());
    }
}
