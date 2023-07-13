package com.anthonytabet.portfol.service;

import com.anthonytabet.portfol.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getCommentsByPostId(Long postId);
    Comment addComment(Comment comment, Long postId);
    List<Comment> getAllComments();
}
