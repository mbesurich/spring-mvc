package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAOimpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarDAOimpl carDAOimpl;

    @Autowired
    public CarController(CarDAOimpl carDAOimpl) {
        this.carDAOimpl = carDAOimpl;
    }

    @GetMapping()
    public String getSomeCars(@RequestParam(required = false, defaultValue = "2147483647") int count, Model model) {
        model.addAttribute("someCars", carDAOimpl.showSomeCars(count));
        return "/someCars";
    }


}
