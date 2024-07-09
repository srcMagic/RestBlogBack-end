package com.Blog.tirocinio.service;

import com.Blog.tirocinio.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(long theId);

    Post savePost(Post post);

    void deleteById(long theId);
}
