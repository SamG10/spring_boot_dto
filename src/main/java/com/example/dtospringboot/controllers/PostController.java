package com.example.dtospringboot.controllers;

import com.example.dtospringboot.dto.PostCreateDto;
import com.example.dtospringboot.dto.PostReadDto;
import com.example.dtospringboot.models.Post;
import com.example.dtospringboot.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostReadDto> create(@Valid @RequestBody()PostCreateDto postCreateDto) {
        return new ResponseEntity<PostReadDto>(this.postService.create(postCreateDto), HttpStatus.CREATED);
    }

}
