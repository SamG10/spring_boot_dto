package com.example.dtospringboot.services;

import com.example.dtospringboot.convertors.DtoConvertor;
import com.example.dtospringboot.dto.comment.CommentCreateDto;
import com.example.dtospringboot.dto.comment.CommentReadDto;
import com.example.dtospringboot.models.Comment;
import com.example.dtospringboot.models.Post;
import com.example.dtospringboot.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    DtoConvertor dtoConvertor;

    public CommentReadDto create(Post post, CommentCreateDto commentCreateDto) {
        Comment commentEntity = dtoConvertor.convertToEntity(commentCreateDto, Comment.class);
        commentEntity.setPost(post);
        Comment comment = this.commentRepository.save(commentEntity);

        return (CommentReadDto) dtoConvertor.convertToDto(comment, CommentReadDto.class);
    }

    public List<Comment> findAll(Post post) {
        List<Comment> comments = post.getComments();
        return comments;
    }
}
