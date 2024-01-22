package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.util.Arrays;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 19.04.2023
 */
public class EqualsAndHashcode {
    private int val;
    private String name;
    private int[] arr;
    private double dval;

    EqualsAndHashcode(int val, String name, int[] arr, double dval) {
        this.name = name;
        this.val = val;
        this.arr = arr;
        this.dval = dval;
    }

    public static void main(String[] args) {
//        equalsTest();
        hashCodeTest();
    }

    public static void equalsTest() {
        EqualsAndHashcode obj1 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);
        EqualsAndHashcode obj2 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);
        EqualsAndHashcode obj3 = new EqualsAndHashcode(999, "Hello", null, 2.2299);
        EqualsAndHashcode obj4 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);

        System.out.println("Сравнение объектов одного типа:");
        System.out.println("Рефлексивность");
        System.out.println(obj1.equals(obj1));
        Utils.line();
        System.out.println("Симметричность");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj2.equals(obj1));
        Utils.line();
        System.out.println("Согласованность");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(obj2));
        Utils.line();
        System.out.println("Транзитивность");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj2.equals(obj4));
        System.out.println(obj4.equals(obj1));
        Utils.line();
        System.out.println("Сравнение null");
        System.out.println(obj1.equals(null));
        Utils.line();
        //---------------------------------------------------------------
        Utils.line();
        System.out.println("Рефлексивность (другой объект)");
        System.out.println(obj2.equals(obj2));
        Utils.line();
        System.out.println("Симметричность (для разных объектов)");
        System.out.println(obj1.equals(obj3));
        System.out.println(obj3.equals(obj1));
        Utils.line();
        System.out.println("Согласованность (для разных объектов)");
        System.out.println(obj1.equals(obj3));
        System.out.println(obj1.equals(obj3));
        System.out.println(obj1.equals(obj3));
        Utils.line();
        System.out.println("Транзитивность (для разных объектов)");
        System.out.println(obj1.equals(obj3));
        System.out.println(obj3.equals(obj4));
        System.out.println(obj4.equals(obj1)); // допустимо
        Utils.line();
        System.out.println("Сравнение null");
        System.out.println(obj3.equals(null));
        Utils.line();
        //---------------------------------------------------------------
        Utils.line();
        String val = "Hello";
        System.out.println("Сравнение со String");
        System.out.println("Симметричность (для разных объектов)");
        System.out.println(obj1.equals(val));
        System.out.println(val.equals(obj1));
        line();
        System.out.println("Согласованность (для разных объектов)");
        System.out.println(obj1.equals(val));
        System.out.println(obj1.equals(val));
        System.out.println(obj1.equals(val));
        line();
        System.out.println("Транзитивность (для разных объектов)");
        System.out.println(obj1.equals(val));
        System.out.println(val.equals(obj4));
        System.out.println(obj4.equals(obj1)); // допустимо
        line();
    }

    public static void hashCodeTest() {
        EqualsAndHashcode obj1 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);
        EqualsAndHashcode obj2 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);
        EqualsAndHashcode obj3 = new EqualsAndHashcode(999, "Hello", null, 2.2299);
        EqualsAndHashcode obj4 = new EqualsAndHashcode(5, "Hello", new int[]{0,1,5}, 7.77999);

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
        line();
        System.out.println(obj1.hashCode() == obj2.hashCode());
        System.out.println(obj2.hashCode() == obj3.hashCode());
        System.out.println(obj3.hashCode() == obj4.hashCode());
        System.out.println(obj4.hashCode() == obj1.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        /*
        Требования к equals:
        - Рефлексивность: x.equals(x) - true при x != null
        - Симметричность: x.equals(y) и y.equals(x) true
        - Согласованность: повторный вызов x.equals(y) не должен меняться
        - Транзитивность: x.equals(y) - true, y.equals(z) - true, тогда x.equals(z) тоже - true
        - Сравнение null: x.equals(null) - false

        Не забываем про Comparable, т.е. x.equals(y) == true, когда x.compareTo(y) == 0
         */
        if (this == obj) return true;
        if (obj == null) return false;

        // при instanceof могут быть нарушены правила симметричности и транзитивности
        // но данный вариант нарушает принцип подстановки Барбары Лисков (SOLID):
        // вызывающий код должен работать с базовым классом точно так же, как и с его подклассами, не зная об этом
        // так что при конкретной реализации надо смотреть что важнее в конкретном случае
        if (obj.getClass() == this.getClass()) {
            EqualsAndHashcode other = (EqualsAndHashcode) obj;
            return this.val == other.val &&
                   this.name.equals(other.name) &&
                    Arrays.equals(this.arr, other.arr) &&
                    Double.compare(this.dval, other.dval) == 0;
        }
        return false;

        /*
        Когда НЕ стоит переопределять этот метод:
        - Когда каждый экземпляр класса является уникальным: класс Thread, для Enum-ов
        - Когда на самом деле от класса не требуется определять эквивалентность его экземпляров: java.util.Random
        - Когда класс, который вы расширяете, уже имеет свою реализацию метода equals и поведение этой реализации вас устраивает: для классов Set, List, Map
        - Когда область видимости вашего класса является private или package-private и вы уверены, что этот метод никогда не будет вызван
         */

        /*
        В случае наследования можно воспользоваться таким кодом:
        Допустим добавили поле int color, то:
        if (!(obj instanceof EqualsAndHashcode)) return false;
        return super.equals(obj) && ((EqualsAndHashcode) obj).color == color;
         */
    }

    @Override
    public int hashCode(){
        /*
        Требования:
        - Вызов метода hashCode один и более раз над одним и тем же объектом должен возвращать одно и то же хэш-значение,
          при условии, что поля объекта, участвующие в вычислении значения, не изменялись.
        - Вызов метода hashCode над двумя объектами должен всегда возвращать одно и то же число,
          если эти объекты равны (вызов метода equals для этих объектов возвращает true).
        - Вызов метода hashCode над двумя неравными между собой объектами должен возвращать разные хэш-значения. Не является обязательным
         */
        // В развернутом виде:
        int result;
        long temp;
        result = val;
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(arr);
        temp = Double.doubleToLongBits(dval);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;

        // Или инкапсулированно:
//        int result = Objects.hash(val, name, dval); // под капотом тот же Arrays.hashCode(Object ... varArgs);
//        result = 31 * result + Arrays.hashCode(arr);
//        return result;
    }
}
