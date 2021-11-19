package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
//@RequestMapping("/users")
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

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String editUserPost(@PathVariable("id") int id, User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update";
        }
        userService.add(user);
        model.addAttribute("user", userService.show());
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }


//    @GetMapping()
//    public String getUsers(@RequestParam(required = false, defaultValue = "2147483647") int count, Model model) {
//        model.addAttribute("users", userService.show(count));
//        return "someUsers";
//    }
//
//    @GetMapping("/{id}")
//    public String showUserById(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "user";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") @Valid User user ){
//        return "new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("person") @Valid User user,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "new";
//
//        userService.add(user);
//        return "users";
//    }
}
