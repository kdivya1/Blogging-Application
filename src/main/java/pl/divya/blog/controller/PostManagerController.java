package pl.divya.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.divya.blog.entity.Post;

import pl.divya.blog.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/post")
public class PostManagerController {

    @Autowired
    PostService postService;
  
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    

    @GetMapping("/addNewPost")
    public String showFormNewPost(Model model) {
        
        
        Post post = new Post();
     
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
      
    
        model.addAttribute("username",username);
        model.addAttribute("post", post);
    
        return "post-form";
    }

    @PostMapping("/addNewPost")
    public String processAddNewPost(@ModelAttribute("post") Post post, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        int userId = userService.getUserByName(username).getId();
        
        post.setUsername(username);
        post.setId_user(userId);
        
        postService.addNewPost(post);
        
        return "redirect:/admin";
    }


    @RequestMapping("/editPost")
    public String showEditPostForm(Model model, @RequestParam("postId") int postId) {
      
        Post post = postService.getPostById(postId);
       

        model.addAttribute("post", post);
       
        return "post-form";
    }

    @PostMapping("/editPost")
    public String processEditingPost(@ModelAttribute("post") Post post, HttpServletRequest request,Model model) {
        processAddNewPost(post, request);
        model.addAttribute("page",1);
        return "redirect:/admin";
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("postId") int id) {
        postService.deletePost(id);
        return "redirect:/admin";
    }

    @RequestMapping("/deleteAllPosts")
    public String deleteAllPosts(){
        postService.deleteAllPosts();
        return "redirect:/admin";
    }
}