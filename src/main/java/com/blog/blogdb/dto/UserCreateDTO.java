package com.blog.blogdb.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    private String username;
    private String email;
}
