package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDAOimpl;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAOimpl userDAOimpl;

    @Autowired
    public UserController(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    @GetMapping()
    public String getSomeCars(@RequestParam(required = false, defaultValue = "2147483647") int count, Model model) {
        model.addAttribute("users", userDAOimpl.show(count));
        return "/users";
    }
}
