package pro.shamilabd.junit5;

import java.util.Objects;

public class Bird {
    private String name;
    private int age;
    private String color;

    private Beak beak;

    public Bird() {
    }

    public Bird(String name, int age, String color, Beak beak) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.beak = beak;
    }

    public Beak getBeak() {
        return beak;
    }

    public void setBeak(Beak beak) {
        this.beak = beak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bird bird = (Bird) o;

        if (age != bird.age) return false;
        if (!Objects.equals(name, bird.name)) return false;
        return Objects.equals(color, bird.color);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
