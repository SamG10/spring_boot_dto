package com.example.dtospringboot.dto;

import lombok.Data;

@Data
public class PostReadDto implements PostDto {
    private Integer id;
    private String title;
    private String content;
    private String description;
}
