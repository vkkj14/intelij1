package com.intelij.intelij1.service.impl;

import com.intelij.intelij1.entity.Comment;
import com.intelij.intelij1.entity.Post;
import com.intelij.intelij1.exception.ResourceNotFoundException;
import com.intelij.intelij1.payload.CommentDto;
import com.intelij.intelij1.repository.CommentRepository;
import com.intelij.intelij1.repository.PostRepository;
import com.intelij.intelij1.service.CommentService;
import org.hibernate.binder.internal.CommentsBinder;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

      Post post= postRepository.findById(postId).orElseThrow(
                  ()-> new ResourceNotFoundException("Post Not found with id:" +postId)
            );

        Comment comment =new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        CommentDto dto=new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return dto;
    }
}
