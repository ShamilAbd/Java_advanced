package pro.shamilabd.lambda;

import java.util.ArrayList;
import java.util.function.Supplier;
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class SupplierEx {
    public static void main(String[] args) {
        ArrayList<Car> cars = createThreeCars(() -> new Car("Nissan Tiida", "yellow", 1.6));
        System.out.println(cars);
    }

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(carSupplier.get());
        }
        return cars;
    }
}

class Car {
    private String model;
    private String color;
    private double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" + model + ", " + color + ", engine=" + engine + '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
}
