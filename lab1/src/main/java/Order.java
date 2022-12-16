import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;


public class Order {
    private String id = UUID.randomUUID().toString();
    private Car car;
    private Customer customer;
    private int hour;
    private double cost;
    private boolean permission;

    public Order(Car car, Customer customer, int hour, boolean permission, double cost) {
        this.car = car;
        this.customer = customer;
        this.permission = permission;
        this.cost = cost;
        this.hour=hour;
    }

    public Car getCar() {
        return car;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return hour == order.hour && cost == order.cost && permission == order.permission && id.equals(order.id) && car.equals(order.car) && customer.equals(order.customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id:'" + id + '\'' +
                "\n Car: " + car.getBrand() +
                "," + car.getModel() +

                "\n Customer: " + customer.getSurname() +
                " " + customer.getName() +
                "\n Permission: " + permission +
                "\n cost: " + cost +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, customer, permission,cost);
    }



    public static class OrderBuilder{

        private String id = UUID.randomUUID().toString();
        private Car car;
        private Customer customer;
        private double cost;
        private int hour;
        private boolean permission;

        public Order.OrderBuilder car(Car car){
            this.car=car;
            return this;
        }
        public Order.OrderBuilder customer(Customer customer){
                  this.customer=customer;
                  return this;
        }

        public Order.OrderBuilder cost(int hour){
            this.cost=car.getPricePerHour()*hour;
            return this;
        }

        public Order.OrderBuilder permission(boolean permission){
            this.permission=permission;
            return this;
        }

        public Order build(){
            return new Order(car,customer,hour,permission,cost);
        }

    }
}
