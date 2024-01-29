package com.intelij.intelij1.controller;


import com.intelij.intelij1.payload.CommentDto;
import com.intelij.intelij1.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //http://localhost:8081/api/comments?postId=1

    @PostMapping

    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId

            )
    {
     CommentDto dto= commentService.createComment(commentDto,postId);

     return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
