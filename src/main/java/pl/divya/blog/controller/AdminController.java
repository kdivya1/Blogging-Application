package pl.divya.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.divya.blog.entity.Post;
import pl.divya.blog.entity.User;

import pl.divya.blog.service.PostService;

import pl.divya.blog.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PostService postService;
   
   
    @Autowired
    UserService userService;
   


    @RequestMapping
    public String showAdminMenu(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
     
     
        model.addAttribute("username",username);
        return "admin-menu";
    }

    @RequestMapping("/managePosts")
    public String showPostManager(Model model, @RequestParam("page") int page) {
        int numberOfPages = postService.postCount();
        if(numberOfPages%5==0){
            numberOfPages = numberOfPages/5;
        }
        else {
            numberOfPages = numberOfPages/5+1;
        }
        List<Integer> listOfPages = new ArrayList<>();
        for(int i = 0; i < numberOfPages; i++){
            if(i>=(page-4) && (i<=page+4)){
                listOfPages.add(i);
            }
        }
        List<Post> posts = postService.getPostsByLimit((page-1)*5,5);
        for (Post post : posts) {
            post.setContent(post.getContent().substring(0, Math.min(post.getContent().length(), 200)) + "...");
            
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
      
    
        model.addAttribute("username",username);
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage",page);
        model.addAttribute("listOfPages",listOfPages);
        return "post-manager";
    }


    @RequestMapping("/manageUsers")
    public String showUserManager(Model model) {
        List<User> users = userService.getAllUsers();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
      
        model.addAttribute("username",username);
        model.addAttribute("username", username);
        model.addAttribute("users", users);
        return "user-manager";
    }
}
