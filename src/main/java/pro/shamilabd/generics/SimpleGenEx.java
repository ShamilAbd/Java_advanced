package pro.shamilabd.generics;

import java.util.ArrayList;
import java.util.List;

import static pro.shamilabd.Utils.line;

public class SimpleGenEx {
    public static void main(String[] args) {
        DiamondDecorator<String> testGeneric = new DiamondDecorator<>("Hello");
        System.out.println(testGeneric);
        line();

//        DiamondDecorator<Double> doubleTest = new DiamondDecorator<>("Hello"); // can't write
        DiamondDecorator<Double> doubleTest = new DiamondDecorator<>(3.14);
        System.out.println(doubleTest);
        line();

        Pair<String, Integer> pairTest1 = new Pair<>("Test", 5);
        System.out.println("Test 1. First value: " + pairTest1.getFirst()
                + ", second value: " + pairTest1.getSecond());
        line();

        Pair<Integer, Double> intDouble = new Pair<>(77, 3.14);
        System.out.println("Int and Double test. First value: " + intDouble.getFirst()
                + ", second value: " + intDouble.getSecond());
        line();

        List<String> strings = new ArrayList<>();
        strings.add("First");
        strings.add("Second");
        String firstElement = DiamondDecorator.getFirstElement(strings);
        System.out.println(firstElement);
        line();

        List<Boolean> bools = new ArrayList<>();
        bools.add(true);
        bools.add(false);
        boolean firstBooleanElement = DiamondDecorator.getFirstElement(bools);
        System.out.println(firstBooleanElement);
        line();
    }
}

class DiamondDecorator<T> { // T is typePlaceholder, he can be T,K,V or other, but this is recommended for using
    private T value; // can't be static field

    public DiamondDecorator(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // Generic method. Here <T> is mark, that this method return generic type
    // In generic class we can skip <T>
    public static <T> T getFirstElement(List<T> arrayList) {
        return arrayList.get(0);
    }

    public String toString() {
        return "<" + value.toString() + ">";
    }
}

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}