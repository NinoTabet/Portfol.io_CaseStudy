package com.anthonytabet.portfol.service;

import com.anthonytabet.portfol.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(Long postId);
    Comment addComment(Comment comment, Long postId);
    List<Comment> getAllComments();
}
