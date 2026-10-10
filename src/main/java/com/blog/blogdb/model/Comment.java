package com.blog.blogdb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User author;
}
