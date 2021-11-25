package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.show());
        return "users";
    }

    @GetMapping("/user/{id}")
    public String showUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

//    creating start------------------------------------------------------------
    @RequestMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
//    creating end------------------------------------------------------------

//    updating start------------------------------------------------------------
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String editUserPost(@PathVariable("id") Long id, User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update";
        }
        userService.add(user);
        model.addAttribute("user", userService.show());
        return "redirect:/";
    }
//    updating end------------------------------------------------------------

    @RequestMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

//    Sprint Security - start --------------------------------------------------
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

//    Sprint Security - finish --------------------------------------------------
}
