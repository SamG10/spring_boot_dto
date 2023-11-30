package com.example.dtospringboot.controllers;

import com.example.dtospringboot.dto.comment.CommentCreateDto;
import com.example.dtospringboot.dto.comment.CommentReadDto;
import com.example.dtospringboot.dto.post.PostCreateDto;
import com.example.dtospringboot.dto.post.PostReadDto;
import com.example.dtospringboot.models.Comment;
import com.example.dtospringboot.models.Post;
import com.example.dtospringboot.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostReadDto> create(@Valid @RequestBody() PostCreateDto postCreateDto) {
        return new ResponseEntity<PostReadDto>(this.postService.create(postCreateDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Post> getAll() {
        return this.postService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> findOne(@Param("id") String id) {
        return this.postService.findById(id);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentReadDto> createComment(@PathVariable("id") String postId, @Valid @RequestBody() CommentCreateDto commentCreateDto) {
        return new ResponseEntity<CommentReadDto>(this.postService.createComment(postId, commentCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/comment")
    public List<Comment> findAll(@PathVariable("id") String postId) {
        return this.postService.findAllComment(postId);
    }


}
