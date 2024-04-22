package web.carDao;
import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    public List<Car> list = new ArrayList<>();
    @Override
    public List<Car> getCarsList() {
        list.add(new Car("BMW", "X6", "Black"));
        list.add(new Car("Audi", "Q7", "White"));
        list.add(new Car("VW", "Jetta", "Blue"));
        list.add(new Car("Toyota", "Prius", "Yellow"));
        list.add(new Car("Kia", "K5", "Green"));
        return list;
    }
    @Override
    public List<Car> carsCount (int num) {
        if (num == 0 || num > list.size()) {
            return list;
        } else {
            return list.subList(0, num).stream().limit(5).collect(Collectors.toList());
        }
    }
}
