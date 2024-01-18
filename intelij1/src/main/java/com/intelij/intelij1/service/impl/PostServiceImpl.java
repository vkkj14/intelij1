package com.intelij.intelij1.service.impl;

import com.intelij.intelij1.entity.Post;
import com.intelij.intelij1.exception.ResourceNotFoundException;
import com.intelij.intelij1.payload.PostDto;
import com.intelij.intelij1.repository.PostRepository;
import com.intelij.intelij1.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        //m2
        Post post = mapToEntity(postDto);

        Post savedPost = postRepository.save(post);


//        PostDto dto = new PostDto();
//        dto.setTitle(savedPost.getTitle());
//        dto.setDescription(savedPost.getDescription());
//        dto.setContent(savedPost.getContent());

        //m2:-automatically convert into dto object
        PostDto dto = mapToDto(savedPost);

        return dto;
    }

    @Override
    public  PostDto getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post Not Found With id: "+id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize){
        PageRequest pageable=PageRequest.of(pageNo,pageSize);
        Page<Post> pagePost= postRepository.findAll(pageable);
        List<Post> posts= pagePost.getContent();

//        List<Post> posts = postRepository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post post){

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

}