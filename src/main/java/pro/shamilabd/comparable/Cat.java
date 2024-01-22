package pro.shamilabd.comparable;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.04.2023
 */
public class Cat {
    private String name;
    private String sex;
    private double weight;

    public Cat(String name, String sex, double weight) {
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
        return "Cat{"
                + "name='" + name + '\''
                + ", sex='" + sex + '\''
                + ", weight=" + weight
                + '}';
    }
}
