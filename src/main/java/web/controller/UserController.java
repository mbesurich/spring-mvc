package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.Set;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userRole")
    public String userStartPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        Set<Role> roles = user.getRoleSet();
        boolean isAdmin = false;
        for(Role role : roles) {
            if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }
        model.addAttribute("isAdmin", isAdmin);
        return "userRole";
    }

    @GetMapping("/login")
    public String login (@RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            return "error";
        } else {
            return "login";
        }
    }
}
