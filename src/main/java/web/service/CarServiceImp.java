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

    @Autowired
    private CarDAO carDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Car> showSomeCars(int quantity) {
        return carDAO.showSomeCars(quantity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> showAllCars() {
        return carDAO.showAllCars();
    }
}
