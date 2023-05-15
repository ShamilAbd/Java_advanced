package com.shamilabd.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class ConsumerEx {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Nissan", "Silver", 1.6));
        cars.add(new Car("Volvo", "Black", 2.0));
        cars.add(new Car("Vaz", "Yellow", 1.6));
        cars.add(new Car("Gaz", "White", 2.2));
        cars.forEach((car) -> System.out.println(car.toString())); // Consumer

        changeCar(cars.get(2), (car -> System.out.println(car.getColor())));
        changeCar(cars.get(3), car -> {
            car.setColor("Purple");
            car.setEngine(5.5);
            System.out.println(car.getEngine()); });
        changeCar(cars.get(3), (car -> System.out.println(car)));
    }

    public static void changeCar(Car car, Consumer<Car> action) {
        action.accept(car);
    }
}
