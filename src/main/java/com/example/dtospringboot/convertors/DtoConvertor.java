package com.example.dtospringboot.convertors;

import com.example.dtospringboot.dto.PostDto;
import com.example.dtospringboot.models.Post;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoConvertor {
    public PostDto convertToDto(Post post, PostDto postDto){
        return new ModelMapper().map(post,postDto.getClass());
    }

    public Post convertToEntity(Post post, PostDto postDto){
        return new ModelMapper().map(postDto,post.getClass());
    }
}
