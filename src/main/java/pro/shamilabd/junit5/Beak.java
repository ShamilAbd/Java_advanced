package pro.shamilabd.junit5;

import java.util.Objects;

public class Beak {
    private String form;
    private int hardness;
    private String color;

    public Beak() {
    }

    public Beak(String form, int hardness, String color) {
        this.form = form;
        this.hardness = hardness;
        this.color = color;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beak beak = (Beak) o;

        if (hardness != beak.hardness) return false;
        if (!Objects.equals(form, beak.form)) return false;
        return Objects.equals(color, beak.color);
    }

    @Override
    public int hashCode() {
        int result = form != null ? form.hashCode() : 0;
        result = 31 * result + hardness;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beak{" +
                "form='" + form + '\'' +
                ", hardness=" + hardness +
                ", color='" + color + '\'' +
                '}';
    }
}
