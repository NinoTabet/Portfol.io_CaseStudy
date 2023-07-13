package com.anthonytabet.portfol.service.impl;

import com.anthonytabet.portfol.model.Comment;
import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.repository.CommentRepository;
import com.anthonytabet.portfol.repository.PostRepository;
import com.anthonytabet.portfol.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Comment Service Implementation is used for providing the list of comments per post, and adding new comments
@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment addComment(Comment comment, Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            comment.setPost(post);
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Post not found for id: " + postId);
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAllByOrderByTimestampDesc();
    }
}
