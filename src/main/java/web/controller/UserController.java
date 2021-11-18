package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAOimpl;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(@RequestParam(required = false, defaultValue = "2147483647") int count, Model model) {
        model.addAttribute("users", userService.show(count));
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") @Valid User user ){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.add(user);
        return "redirect:/users";
    }
}
