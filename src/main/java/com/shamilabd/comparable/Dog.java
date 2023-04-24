package com.shamilabd.comparable;

import java.util.Comparator;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 25.04.2023
 */
public class Dog implements Comparable<Dog> {
    private String name;
    private String sex;
    private double weight;

    public Dog(String name, String sex, double weight) {
        this.weight = weight;
        this.name = name;
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Dog otherDog) {
        int compWeight = (int)((this.getWeight() - otherDog.getWeight()) * 10); // yes, bad idea put long in int.
        if (compWeight == 0){
            int compName = this.name.compareTo(otherDog.name);
            if (compName == 0){
                return this.sex.compareTo(otherDog.sex);
            }
        }
        return compWeight;
    }
}
