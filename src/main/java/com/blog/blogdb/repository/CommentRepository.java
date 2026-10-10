package com.blog.blogdb.repository;

import com.blog.blogdb.model.Comment;
import com.blog.blogdb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long postId);
}
