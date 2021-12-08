package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

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

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        Set<Role> roles = userService.getAllRoles();
        model.addAttribute("roles", roles);
        return "new";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("user") User user, @RequestParam(value = "checkRoles") String[] checkRoles) {
        Set<Role> roleHashSet = new HashSet<>();
        for (String role : checkRoles) {
            roleHashSet.add(userService.getRoleByName(role));
        }
        user.setRoleSet(roleHashSet);
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String editUserPost(@PathVariable("id") Long id, @ModelAttribute("user") User user, @RequestParam(value = "checkRoles") String[] checkRoles) {
        Set<Role> roleHashSet = new HashSet<>();
        for (String role : checkRoles) {
            roleHashSet.add(userService.getRoleByName(role));
        }
        user.setRoleSet(roleHashSet);
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
