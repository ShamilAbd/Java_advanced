package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class SomeStatements {
    public static void main(String[] args) {
        int val = 35;
        // if statement
        if(val > 5) System.out.println("val > 5 and = "+ val);

        if(val > 5) System.out.println("val > 5 and = "+ val);
        else System.out.println("val <= 5 and = "+ val);

        if(val > 50) System.out.println("val > 50 and = "+ val);
        else if(val > 40) System.out.println("val > 40 and = "+ val);
        else if(val > 30) System.out.println("val > 30 and = "+ val);
        else if(val > 15) System.out.println("val > 15 and = "+ val);
        else System.out.println("val <= 15 and = "+ val);

        // nested if
        if(val > 5) {
            System.out.println("val > 5 and = "+ val);
            if(val > 5000) System.out.println("val > 5000 and = "+ val);
            else System.out.println("val <= 5000 and = "+ val);
        }
        else System.out.println("val <= 5 and = "+ val);
        Utils.line();

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = car1;

        if(car1 == car3) System.out.println("Car1 == Car3");

        if(car1 == car2) System.out.println("Car1 == Car2");
        else System.out.println("Car1 != Car2");

        if(car1.equals(car2)) System.out.println("car1.equals(car2) = TRUE");
        else System.out.println("NOT car1.equals(car2)");
        Utils.line();

        House h1 = new House();
        House h2 = new House();
        House h3 = h1;

        if(h1 == h3) System.out.println("h1 == h3");

        if(h1 == h2) System.out.println("h1 == h2");
        else System.out.println("h1 != h2");

        if(h1.equals(h2)) System.out.println("h1.equals(h2) = TRUE");
        else System.out.println("NOT h1.equals(h2)");
        Utils.line();

        String val1 = "hello";
        String val2 = "hello"; // String pool
        String val3 = "HeLLo";

        if(val1 == val3) System.out.println("val1 == val3");
        else System.out.println("val1 != val3");

        if(val1 == val2) System.out.println("val1 == val2");
        else System.out.println("val1 != val2");

        if(val1.equals(val2)) System.out.println("val1.equals(val2) = TRUE");
        else System.out.println("NOT val1.equals(val2)");
        Utils.line();

        String newStringObj1 = new String("hello");
        String newStringObj2 = new String("hello"); // each object is other (address in memory)
        String newStringObj3 = new String("HeLLo");

        if(newStringObj1 == newStringObj3) System.out.println("newStringObj1 == newStringObj3");
        else System.out.println("newStringObj1 != newStringObj3");

        if(newStringObj1 == newStringObj2) System.out.println("newStringObj1 == newStringObj2");
        else System.out.println("newStringObj1 != newStringObj2");

        if(newStringObj1.equals(newStringObj2)) System.out.println("newStringObj1.equals(newStringObj2) = TRUE");
        else System.out.println("NOT newStringObj1.equals(newStringObj2)");
        line();

        // ternary operator
        int ternary = (val > 50) ? val : -1;
        System.out.println(ternary);
        line();

        // old version
        switch (val){ // char, byte, short, int, String
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(5);
                break;
            default:
                System.out.println("default");
        }
        line();

        val = 4;
        // Java 12 version:
        String switchVal = switch (val){
            case 1, 2 -> "Dvoechnik";
            case 3 -> "Troechnik";
            case 4, 5 -> "Norm, good";
            default -> "Not find case!";
        };
        System.out.println(switchVal);




    }
}

// method equals is not override
class Car{
}

// method equals is override
class House{
    private int id = 1; // only for example

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        if(this == obj) return true;

        if(obj instanceof House){
            House other = (House) obj;
            return this.id == other.id;
        }

        return false;
    }
}