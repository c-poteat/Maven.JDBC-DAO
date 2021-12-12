package daos;

import java.util.Set;

public interface CarDao {
    Car getCar();
    Set<Car> getAllCars();
    Car getCarByUserNameAndPassword();
    boolean insertCar();
    boolean updateCar();
    boolean deleteCar();
}
