package pro.shamilabd.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(7);
        int val = test.get(1);
        // After compile:
//        List test = new ArrayList();
//        int val = (Integer) test.get(1);
    }

    public void overloadedProblemMethod(ProblemErasure<String> val) {
        System.out.println("Can't write this 2 methods");
    }

//    public void overloadedProblemMethod(ProblemErasure<Integer> val) {
//        System.out.println("Can't write this 2 methods");
//    }

    // After erasure both methods have next signature:
//    public void overloadedProblemMethod(ProblemErasure val)
}

class ProblemErasure<T> {
    private T value;

    public ProblemErasure(T val) {
        value = val;
    }

    public T getValue() {
        return value;
    }

    public void overrideInChildProblem(ArrayList<String> val) {
        System.out.println("Can't override");
    }
}

class ChildProblem<T> extends ProblemErasure {
    public ChildProblem(T val) {
        super(val);
    }

//    public void overrideInChildProblem(ArrayList<Integer> val) {
//        System.out.println(":-(");
//    }
}