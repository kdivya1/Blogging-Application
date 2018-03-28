package pl.divya.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.divya.blog.entity.Comment;
import pl.divya.blog.entity.Post;


import pl.divya.blog.service.CommentService;
import pl.divya.blog.service.PostService;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
 
    

   


    @RequestMapping("/user/{id}")
    public String showPostsByUser(@PathVariable("id") int id, Model model, @RequestParam("page") int page) {
        int numberOfPages = postService.postCountByUser(id);
        if (numberOfPages % 5 == 0) {
            numberOfPages = numberOfPages / 5;
        } else {
            numberOfPages = numberOfPages / 5 + 1;
        }
        List<Integer> listOfPages = new ArrayList<>();
        for (int i = 0; i < numberOfPages; i++) {
            if (i >= (page - 4) && (i <= page + 4)) {
                listOfPages.add(i);
            }
        }
        List<Post> posts = postService.getPostsByUser(id, (page - 1) * 5, 5);
        for (Post post : posts) {
            post.setContent(post.getContent().substring(0, Math.min(post.getContent().length(), 600)) + "...");
           
        }
    
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username",username);
     
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage", page);
        model.addAttribute("listOfPages", listOfPages);
        model.addAttribute("id", id);
        model.addAttribute("type", "user");
     
        return "main";
    }

    

    @RequestMapping("/id/{id}")
    public String showPosts(@PathVariable("id") int id, Model model) {
        Comment newComment = new Comment();
        List<Comment> comments = commentService.getCommentsByPostId(id);
        model.addAttribute("comments", comments);
        Post post = postService.getPostById(id);
      
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username",username);
     
        model.addAttribute("post", post);
        model.addAttribute("newComment", newComment);
        model.addAttribute("comments", comments);

        return "post";
    }

    @PostMapping("/id/{id}")
    public String addNewComment(@PathVariable("id") int postId, @ModelAttribute("comment") Comment comment,
                                HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        comment.setIp(ip);
        comment.setIdPost(postId);
        commentService.addNewComment(comment);
        String url = request.getRequestURL().toString();
        return "redirect:" + url;
    }

    
}
