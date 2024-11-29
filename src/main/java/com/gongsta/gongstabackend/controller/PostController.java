package com.gongsta.gongstabackend.controller;

import com.gongsta.gongstabackend.dto.PostDTO;
import com.gongsta.gongstabackend.model.Post;
import com.gongsta.gongstabackend.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Post> createPost(@PathVariable Long userId, @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(userId, postDTO));
    }
}
