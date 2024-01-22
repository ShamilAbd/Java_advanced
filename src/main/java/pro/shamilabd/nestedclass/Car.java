package pro.shamilabd.nestedclass;

import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 12.05.2023
 */
public class Car {
    private String name;
    private String color;
    private Engine engine;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Car(String name, String color, int horsePower) {
        this(name, color);
        engine = this.new Engine(horsePower);
    }

    @Override
    public String toString() {
        return "Car{" + name + ", " + color + ", " + engine + '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public class Engine {
        private int horsePower;
        public static int test = 5;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{" + horsePower + '}';
        }

        public int getHorsePower() {
            return horsePower;
        }
    }
}

class CarTest {
    public static void main(String[] args) {
        // Create inner class into external class
        Car car = new Car("Volvo", "Silver", 256);
        System.out.println(car);
        line();

        // Create in other class
//        Car.Engine externalEng = new Car.Engine(300); // can't call - class not static
        Car car2 = new Car("Mazda", "Red");
        Car.Engine externalEng = car2.new Engine(300);
        car2.setEngine(externalEng);
        System.out.println(car2);

        System.out.println(Car.Engine.test);
    }
}
