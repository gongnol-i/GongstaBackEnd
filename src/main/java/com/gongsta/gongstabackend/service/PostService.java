package com.gongsta.gongstabackend.service;

import com.gongsta.gongstabackend.dto.PostDTO;
import com.gongsta.gongstabackend.model.Post;
import com.gongsta.gongstabackend.model.User;
import com.gongsta.gongstabackend.repository.PostRepository;
import com.gongsta.gongstabackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> PostDTO.builder()
                        .imageUrl(post.getImageUrl())
                        .caption(post.getCaption())
                        .username(post.getUser().getUsername())
                        .build())
                .collect(Collectors.toList());
    }

    public Post createPost(Long userId, PostDTO postDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = Post.builder()
                .user(user)
                .imageUrl(postDTO.getImageUrl())
                .caption(postDTO.getCaption())
                .createdAt(LocalDateTime.now())
                .build();
        return postRepository.save(post);
    }
}
