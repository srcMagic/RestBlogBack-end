package com.Blog.tirocinio.repository;

import com.Blog.tirocinio.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
