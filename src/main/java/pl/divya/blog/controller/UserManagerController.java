package pl.divya.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.divya.blog.entity.User;
import pl.divya.blog.service.*;

@Controller
@RequestMapping("/admin/user")
public class UserManagerController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
  
    

    @RequestMapping("/addNewUser")
    public String showFormNewUser(Model model) {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        model.addAttribute("username",username);
        
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/addNewUser")
    public String processAddNewUser(@ModelAttribute("user") User user, Model model) {
        user.setEnabled(1);
        try{
            userService.addNewUser(user);
        }
            catch (Exception e){
            model.addAttribute("duplicate",true);
                
                
            return "admin-menu";
            }
        return "redirect:/admin";
    }

    @RequestMapping("/editUser")
    public String showFormEditUser(Model model, @RequestParam("userId") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/editUser")
    public String processEditUser(@ModelAttribute("user") User user,Model model) {
        processAddNewUser(user,model);
        return "redirect:/admin/manageUsers";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/manageUsers";
    }

}
