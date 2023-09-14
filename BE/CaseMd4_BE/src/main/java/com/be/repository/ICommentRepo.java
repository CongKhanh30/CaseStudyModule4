package com.be.repository;

import com.be.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {
    Comment findByContent (String content);
    List<Comment> findAllByProductId(int productId);
}
