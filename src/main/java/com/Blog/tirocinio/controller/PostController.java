package com.Blog.tirocinio.controller;

import com.Blog.tirocinio.entity.Post;
import com.Blog.tirocinio.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/post")
public class PostController {

    // inject the service
    @Autowired
    private PostService postService;

    // ritorna una lista di tutti i post
    @GetMapping("/all")
    public Iterable<Post> getAll() {
        return this.postService.findAll();
    }

    // cerca un post tramite id
    @GetMapping("{id}")
    public Post getPostById(@PathVariable("id") long theId) {
        return this.postService.findById(theId);
    }

    // crea un nuovo post
    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }


    // elimina un post per id
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long theId) {
        this.postService.deleteById(theId);
    }
}


