package com.example.dtospringboot.services;

import com.example.dtospringboot.convertors.DtoConvertor;
import com.example.dtospringboot.dto.comment.CommentCreateDto;
import com.example.dtospringboot.dto.comment.CommentReadDto;
import com.example.dtospringboot.dto.post.PostCreateDto;
import com.example.dtospringboot.dto.post.PostReadDto;
import com.example.dtospringboot.models.Comment;
import com.example.dtospringboot.models.Post;
import com.example.dtospringboot.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    DtoConvertor dtoConvertor;

    @Autowired
    CommentService commentService;

    public PostReadDto create(PostCreateDto postCreateDto) {

        Post postEntity = dtoConvertor.convertToEntity(postCreateDto, Post.class);
        Post post = this.postRepository.save(postEntity);

        return (PostReadDto) dtoConvertor.convertToDto(post, PostReadDto.class);
    }

    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    public Optional<Post> findById(String id) {
        return this.postRepository.findById(id);
    }

    public CommentReadDto createComment(String postId, CommentCreateDto commentCreateDto) {
        System.out.println("service");
        Post post = this.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        return this.commentService.create(post, commentCreateDto);
    }

    public List<Comment> findAllComment(String postId) {
        Post post = this.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        return this.commentService.findAll(post);
    }


}
