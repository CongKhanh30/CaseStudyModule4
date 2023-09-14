package com.be.service;

import com.be.model.Account;
import com.be.model.Comment;

import java.util.List;

public interface ICommentService {
    Comment findByContent(String content);
    Comment save(Comment comment);
    void delete(int id);
    List<Comment> getAll();
    public List<Comment> findByProductId(int productId);
}
