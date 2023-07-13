package com.anthonytabet.portfol.controller;

import com.anthonytabet.portfol.model.Comment;
import com.anthonytabet.portfol.repository.CommentRepository;
import com.anthonytabet.portfol.repository.PostRepository;
import com.anthonytabet.portfol.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;


import java.util.List;

//comment controller deals with showing comments of a post as well as adding new ones
@Controller
@RequestMapping("/comments")
public class CommentController {


    private CommentRepository commentRepository;
    private CommentService commentService;
    private PostRepository postRepository;

    @Autowired
    public CommentController(CommentService commentService, PostRepository postRepository, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    //shows comments
    @GetMapping("/forYou")
    public String showComments(Model model) {
        List<Comment> comments = commentRepository.findAllByOrderByTimestampDesc();
        if (comments == null || comments.isEmpty()) {
            return "forYou";
        }else {
            model.addAttribute("comment", new Comment());
        }
        return "forYou";
    }

    //adding new comments method
    @PostMapping
    public String addComment(@ModelAttribute("comment") Comment comment, @RequestParam Long postId, HttpServletRequest request) {
        commentService.addComment(comment, postId);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}
