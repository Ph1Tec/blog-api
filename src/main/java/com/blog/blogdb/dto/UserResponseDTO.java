package com.blog.blogdb.dto;
import com.blog.blogdb.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
