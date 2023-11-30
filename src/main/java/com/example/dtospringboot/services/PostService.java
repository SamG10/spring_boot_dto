package com.example.dtospringboot.services;

import com.example.dtospringboot.convertors.DtoConvertor;
import com.example.dtospringboot.dto.PostCreateDto;
import com.example.dtospringboot.dto.PostReadDto;
import com.example.dtospringboot.models.Post;
import com.example.dtospringboot.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    DtoConvertor dtoConvertor;

    public PostReadDto create(PostCreateDto postCreateDto) {

        Post postEntity = dtoConvertor.convertToEntity(new Post(), postCreateDto);
        Post post = this.postRepository.save(postEntity);

        return (PostReadDto) dtoConvertor.convertToDto(post, new PostReadDto());
    }

}
