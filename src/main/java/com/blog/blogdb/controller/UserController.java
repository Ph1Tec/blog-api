package com.blog.blogdb.controller;

import com.blog.blogdb.dto.UserCreateDTO;
import com.blog.blogdb.model.User;
import com.blog.blogdb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User criar(@RequestBody UserCreateDTO dto) {
        return userService.metodoCriar(dto);
    }
    @GetMapping
    public List<User> listar() {
        return userService.metodoListar();
    }
    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }
}
