package com.Blog.tirocinio.service;

import com.Blog.tirocinio.entity.Post;
import com.Blog.tirocinio.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(long theId) {
        Optional<Post> result = postRepository.findById(theId);
        Post p = null;
        if (result.isPresent()) {
            p = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return p;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(long theId) {
        postRepository.deleteById(theId);

    }
}



