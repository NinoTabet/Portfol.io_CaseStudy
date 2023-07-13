package com.anthonytabet.portfol.controller;



import com.anthonytabet.portfol.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


// Post controller deals with post mapping for creating a new post
@Controller
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public String createPost(@RequestParam("photo") MultipartFile photo, @RequestParam("description") String description, RedirectAttributes redirectAttributes) {
        if (photo.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "No photo attached");
            return "redirect:/upload";
        }
        try {
            postService.createPost(photo, description);
            redirectAttributes.addFlashAttribute("message", "Post created successfully!");
            return "redirect:/forYou";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Could not create post");
            return "/upload";
        }
    }


}
