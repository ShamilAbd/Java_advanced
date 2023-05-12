package com.shamilabd.nestedclass;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 10.05.2023
 */
public class Bike {
    private String name;
    private String color;
    private Wheel frontWheel;
    private Wheel backWheel;
    private static int someCount;

    public Bike(String name, String color, Wheel frontWheel, Wheel backWheel) {
        this.name = name;
        this.color = color;
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    @Override
    public String toString() {
        return "Bike{" + name
                + ", " + color
                + ", " + frontWheel
                + ", " + backWheel + '}';
    }

    public static class Wheel {
        private int radius;
        private double pressure;

        public Wheel(int radius, double pressure) {
            this.radius = radius;
            this.pressure = pressure;
            someCount++; // outer class field
        }

        @Override
        public String toString() {
            return "Wheel{" + "R" + radius + ", " + pressure + " MPa}";
        }

        public int getRadius() {
            return radius;
        }

        public double getPressure() {
            return pressure;
        }
    }
}

class TestNestedClass {
    public static void main(String[] args) {
        Bike.Wheel frontWheel = new Bike.Wheel(22, 1.2);
        Bike.Wheel backWheel = new Bike.Wheel(2, 1.5);
        Bike myBike = new Bike("Пенни-фартинг", "Black", frontWheel, backWheel);
        System.out.println(myBike);
    }
}
