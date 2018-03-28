package pl.divya.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class LoginController {
 

    @RequestMapping("/login")
    public String login(Model model) {
        
   
       
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username",username);
        return "login";
    }

    @RequestMapping("/loginfailed")
    public String processLogin(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username",username);
       
       
        model.addAttribute("error", "error");
        return "login";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/blog?page=1";
    }
}
