package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOimpl implements CarDAO{

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 1, 100));
        cars.add(new Car("Mersedes", 2, 101));
        cars.add(new Car("Audi", 3, 103));
        cars.add(new Car("Toyota", 4, 104));
        cars.add(new Car("Lada", 5, 105));
    }

    @Override
    public List<Car> showSomeCars(int quantity) {
        if (quantity > cars.size()) {
            return cars;
        } else {
            return cars.subList(0, quantity);
        }
    }

    @Override
    public List<Car> showAllCars(){
        return cars;
    }
}
