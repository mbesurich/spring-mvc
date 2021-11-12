package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String getAllCars(Model model){
        model.addAttribute("allCars", carDAO.showAllCars());
        return "/allCars";
    }

    @GetMapping("/{count}")
    public String getSomeCars(@PathVariable("count") int count, Model model) {
        model.addAttribute("someCars", carDAO.showSomeCars(count));
        return "/someCars";
    }


}
