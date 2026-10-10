package com.blog.blogdb.controller;

import com.blog.blogdb.dto.PostCreateDTO;
import com.blog.blogdb.dto.PostResponseDTO;
import com.blog.blogdb.model.Post;
import com.blog.blogdb.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponseDTO criar(@RequestBody PostCreateDTO dto) {return postService.criarPost(dto);}
    @GetMapping
    public List<PostResponseDTO> listar(){return postService.listarPosts();}
    @GetMapping("/{id}")
    public PostResponseDTO buscarPorId(@PathVariable Long id){return postService.buscarPorIdResponse(id);}
}
