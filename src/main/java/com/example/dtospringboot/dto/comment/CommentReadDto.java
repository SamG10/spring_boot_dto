package com.example.dtospringboot.dto.comment;

import lombok.Data;

@Data
public class CommentReadDto implements CommentDto {
    private Integer id;
    private String body;
    private String email;
    private String name;
}
