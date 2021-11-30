package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
public class CrudUserController {

    private UserService userService;

    @Autowired
    public CrudUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("users", userService.show());
        return "admin";
    }

    @GetMapping(value = "/allUsers")
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
    @GetMapping("/new")
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
        System.out.println("enter edit method of controller");
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
        return "redirect:/admin";
    }
//    updating end------------------------------------------------------------

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
