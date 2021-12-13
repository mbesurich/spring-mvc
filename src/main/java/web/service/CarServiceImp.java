package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDAO;
import web.model.Car;

import java.util.List;

@Service
@EnableTransactionManagement
public class CarServiceImp implements CarService{


    private CarDAO carDAO;

    @Autowired
    public CarServiceImp(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> showSomeCars(int quantity) {
        return carDAO.showSomeCars(quantity);
    }

    @Override
    public List<Car> showAllCars() {
        return carDAO.showAllCars();
    }
}
