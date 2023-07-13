package com.anthonytabet.portfol.controller;

import com.anthonytabet.portfol.dto.UserDto;
import com.anthonytabet.portfol.model.Comment;
import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.model.User;
import com.anthonytabet.portfol.repository.PostRepository;
import com.anthonytabet.portfol.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//authentication controller deals with get and post mapping of log in, upload, and registration
@Controller
public class AuthController {

    private UserService userService;
    private PostRepository postRepository;

    @Autowired
    public AuthController(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/upload")
    public String upload(){ return "redirect:/forYou";}

    @PostMapping("/login")
    public String login(){ return "redirect:/forYou";}

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/forYou")
    public String getPostsForYou(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("comment", new Comment());
        model.addAttribute("posts", posts);
        return "forYou";
    }

    @GetMapping("/photoPage")
    public String showPhotoPage() {return "photoPage";}
    @GetMapping("/upload")
    public String showUploadPage() {return "upload";}

    @GetMapping("/profile")
    public String showProfile() {return "profile";}

}
