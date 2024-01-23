package pro.shamilabd.junit5;

import java.util.Objects;

public class SimpleBird {

    private Beak beak;


    public SimpleBird(Beak beak) {
        this.beak = beak;
    }

    public Beak getBeak() {
        return beak;
    }

    public void setBeak(Beak beak) {
        this.beak = beak;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleBird that = (SimpleBird) o;

        return beak.equals(that.beak);
    }

    @Override
    public int hashCode() {
        return beak.hashCode();
    }

    @Override
    public String toString() {
        return "SimpleBird{" +
                "beak=" + beak +
                '}';
    }
}
