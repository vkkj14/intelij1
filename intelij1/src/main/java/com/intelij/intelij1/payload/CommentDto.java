package com.intelij.intelij1.payload;


import lombok.Data;

@Data
public class CommentDto {

    private long id;

    private String text;
    private String email;

}
