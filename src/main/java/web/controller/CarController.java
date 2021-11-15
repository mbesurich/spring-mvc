package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String getAllCars(Model model){
        model.addAttribute("allCars", carDAOimpl.showAllCars());
        return "/allCars";
    }

    @GetMapping("/{count}")
    public String getSomeCars(@PathVariable("count") int count, Model model) {
        model.addAttribute("someCars", carDAOimpl.showSomeCars(count));
        return "/someCars";
    }


}
