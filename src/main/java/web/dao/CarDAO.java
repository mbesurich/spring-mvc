package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDAO {

    List<Car> showSomeCars(int quantity);
    List<Car> showAllCars();
}
