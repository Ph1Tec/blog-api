package com.blog.blogdb.controller;

import com.blog.blogdb.dto.CommentCreateDTO;
import com.blog.blogdb.dto.CommentResponseDTO;
import com.blog.blogdb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponseDTO criar(@RequestBody CommentCreateDTO dto) {
        return commentService.criarComentario(dto);
    }
    @GetMapping("/post/{postId}")
    public List<CommentResponseDTO> listar(@PathVariable Long postId){
        return commentService.listarPorPost(postId);
    }
}
