package com.blog.blogdb.service;

import com.blog.blogdb.dto.PostCreateDTO;
import com.blog.blogdb.dto.PostResponseDTO;
import com.blog.blogdb.handler.PostNotFoundException;
import com.blog.blogdb.model.Post;
import com.blog.blogdb.model.User;
import com.blog.blogdb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostResponseDTO criarPost(PostCreateDTO dto) {
        Post post = new Post();
        User user = userService.buscarPorId(dto.getAuthorId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(user);
        post.setCreatedAt(LocalDateTime.now());
        return new PostResponseDTO(postRepository.save(post));
    }
    public List<PostResponseDTO> listarPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> new PostResponseDTO(post))
                .toList();
    }

    public Post buscarPorId(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new PostNotFoundException("Post não encontrado"));
    }

    public PostResponseDTO buscarPorIdResponse(Long id) {
        Post post = buscarPorId(id);
        return new PostResponseDTO(post);
    }
}