package com.example.dtospringboot.repositories;

import com.example.dtospringboot.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
