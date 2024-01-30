package com.intelij.intelij1.service;

import com.intelij.intelij1.payload.CommentDto;

public interface CommentService {


    static void deleteComment(long id) {
    }

    CommentDto createComment(CommentDto commentDto, long postId);


    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
