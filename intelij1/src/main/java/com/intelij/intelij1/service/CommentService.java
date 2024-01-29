package com.intelij.intelij1.service;

import com.intelij.intelij1.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,long postId);
}
