package com.example.dtospringboot.repositories;

import com.example.dtospringboot.models.Comment;
import com.example.dtospringboot.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
