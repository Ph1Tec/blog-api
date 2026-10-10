package com.blog.blogdb.service;

import com.blog.blogdb.dto.UserCreateDTO;
import com.blog.blogdb.handler.UserNotFoundException;
import com.blog.blogdb.model.User;
import com.blog.blogdb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;

   public User metodoCriar(UserCreateDTO dto){
       User user = new User();
       user.setUsername(dto.getUsername());
       user.setEmail(dto.getEmail());
       return userRepository.save(user);
   }

   public List<User> metodoListar(){
       return userRepository.findAll();
   }

   public User buscarPorId(Long id){
       return userRepository.findById(id)
               .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
   }
}
