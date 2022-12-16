import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {

    public int compare(Car car1, Car car2) {
        if (car1.getMileageCar() == car2.getMileageCar())
            return 0;

        if (car1.getMileageCar() > car2.getMileageCar())
             return 1;
        else return -1;
    }
}
