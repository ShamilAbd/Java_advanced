package pro.shamilabd.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 05.05.2023
 */
public class Search {
    public static void main(String[] args) {
        intSearchTest();
        catSearchTest();
    }

    public static void intSearchTest() {
        int[] nums = {-5, 6, 1, 0, -9, -2, 7, 13, 100, -30, -2, 4};
        System.out.println(Arrays.toString(nums));
        line();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        line();

        System.out.println("Index num 13: " + Arrays.binarySearch(nums, 13));
        line();
    }

    public static void catSearchTest() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Myrka", 5));
        cats.add(new Cat("Leo", 3));
        cats.add(new Cat("Sumo", 15));
        cats.add(new Cat("Ice", 7));
        cats.add(new Cat("Shoma", 6));
        cats.add(new Cat("Muhomor", 6));

        System.out.println(cats);
        line();
        Collections.sort(cats); // we mast implement Comparable
        System.out.println(cats);
        line();
        int shomaIndex = Collections.binarySearch(cats, new Cat("Shoma", 6));
        System.out.println(shomaIndex);
        line();
    }
}

class Cat implements Comparable<Cat> {
    private String name;
    private int weight;

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat otherCat) {
        return this.weight - otherCat.weight;
    }

    @Override
    public String toString() {
        return "Cat{" + name + ", weight=" + weight + '}';
    }
}