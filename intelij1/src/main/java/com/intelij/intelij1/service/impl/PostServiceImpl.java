package com.intelij.intelij1.service.impl;

import com.intelij.intelij1.entity.Post;
import com.intelij.intelij1.payload.PostDto;
import com.intelij.intelij1.repository.PostRepository;

import com.intelij.intelij1.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost=postRepository.save(post);

        PostDto dto=new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());


        return dto;
    }
}
