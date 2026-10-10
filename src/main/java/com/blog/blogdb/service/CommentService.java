package com.blog.blogdb.service;

import com.blog.blogdb.dto.CommentCreateDTO;
import com.blog.blogdb.dto.CommentResponseDTO;
import com.blog.blogdb.dto.PostResponseDTO;
import com.blog.blogdb.model.Comment;
import com.blog.blogdb.model.Post;
import com.blog.blogdb.model.User;
import com.blog.blogdb.repository.CommentRepository;
import com.blog.blogdb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    public CommentResponseDTO criarComentario(CommentCreateDTO dto){
        Comment comment = new Comment();
        Post post = postService.buscarPorId(dto.getPostId());
        User user = userService.buscarPorId(dto.getAuthorId());
        comment.setContent(dto.getContent());
        comment.setAuthor(user);
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        return new CommentResponseDTO(commentRepository.save(comment));
    }

    public List<CommentResponseDTO> listarPorPost(Long postId){
        return commentRepository.findByPostId(postId)
                .stream()
                .map(comment -> new CommentResponseDTO(comment))
                .toList();
    }
}
