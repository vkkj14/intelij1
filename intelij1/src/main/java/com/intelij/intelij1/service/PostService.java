package com.intelij.intelij1.service;

import com.intelij.intelij1.payload.PostDto;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto postDto);

     PostDto getPostById(long id);

     List<PostDto> getAllPosts(int pageNo, int pageSize);
}
