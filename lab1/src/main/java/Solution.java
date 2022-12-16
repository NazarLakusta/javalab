import enums.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution implements Serializable {

    public static List<Car> sortByStreamMileage(List<Car> car) {

        return car.stream().sorted((c1, c2) -> c1.getMileageCar() - c2.getMileageCar()).collect(Collectors.toList());

    }

    public static List<Car> sortByStreamPrice(List<Car> car) {
        return car.stream().sorted((c1, c2) -> (int) c1.getPricePerHour() - (int) c2.getPricePerHour()).collect(Collectors.toList());

    }

    // Car with mileage < 15000;
    public static List<Car> filterMileageCar(List<Car> car) {
        return car.stream().filter(car1 -> car1.getMileageCar() < 15000).collect(Collectors.toList());
    }

    // Customer  who are 18 years old

    public static List<Customer> filterAdultsCustomer(List<Customer> customers) {
        LocalDate date = LocalDate.now();

        return customers.stream().filter(customer -> ChronoUnit.DAYS.between(date, customer.getBirth()) * (-1) > 6570)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ValidationException {


        Car bmwX5 = new Car.CarBuilder()
                .brand("BMW")
                .model("X5")
                .numberCar("4444")
                .carType(CarType.COUPE)
                .engineType((float) 4.4)
                .fuelType(FuelType.DIESEL)
                .transmission(Transmission.AUTOMATIC)
                .mileageCar(10000)
                .pricePerHour(300)
                .build();

        Car opelVivaro = new Car.CarBuilder()
                .brand("Opel")
                .model("Vivaro")
                .numberCar("0399")
                .carType(CarType.VAN)
                .engineType((float) 1.6)
                .fuelType(FuelType.DIESEL)
                .transmission(Transmission.MECHANICAL)
                .mileageCar(100000)
                .pricePerHour(10)
                .build();

        TreeSet<Car> carsSortForPrice = new TreeSet<Car>();
        carsSortForPrice.add(bmwX5);
        carsSortForPrice.add(opelVivaro);

        System.out.println("List of cars sorted by price ");
        carsSortForPrice.forEach(System.out::println);
        System.out.println("\n");

        ArrayList<Car> carsSortFotMileage = new ArrayList<>();

        carsSortFotMileage.add(bmwX5);
        carsSortFotMileage.add(opelVivaro);

        MileageComparator mileageComparator = new MileageComparator();

        carsSortFotMileage.sort(mileageComparator);

        System.out.println("List of cars sorted by Mileage ");
        carsSortFotMileage.forEach(System.out::println);
        System.out.println("\n");


        System.out.println("Sort by stream  Mileage");
        List<Car> carsList = new ArrayList<>();
        carsList.add(bmwX5);
        carsList.add(opelVivaro);

        sortByStreamMileage(carsList).forEach(System.out::println);


        System.out.println("\nFilter Car with Mileage < 15000");

        filterMileageCar(carsList).forEach(System.out::println);
        Customer customer1 = new Customer.CustomerBuilder()
                .name("Nazar")
                .surname("Lakusta")
                .email("nazarlakusta0303@gmail.com")
                .telephoneNumber("+380957673802")
                .birth(LocalDate.of(2003, 10, 17))
                .build();


        Customer customer2 = new Customer.CustomerBuilder()
                .name("Eduard")
                .surname("Kizan")
                .email("edik030409@gmail.com")
                .telephoneNumber("+380955090232")
                .birth(LocalDate.of(2004, 12, 25))
                .build();

        System.out.println("Filter by  adults");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        filterAdultsCustomer(customers).forEach(System.out::println);
        System.out.println("\n Order");
        Order order = new Order.OrderBuilder().car(bmwX5).customer(customer1).permission(true).cost(5).build();
        System.out.println(order.toString());


     /*   //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("car.txt"));
        objectOutputStream.writeObject(bmwX5);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("car.txt"));
        Car bmwx6Restored = (Car) objectInputStream.readObject();
        objectInputStream.close();*/

    }


}
