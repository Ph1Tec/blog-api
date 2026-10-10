package com.blog.blogdb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne
    private User author;


}
