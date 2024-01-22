package pro.shamilabd.basics.non_access_modifiers;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */

// final class
// NAM - Non Access Modifier
final public class SampleNAM {
    // final fields
    public static final double PI = 3.14;
    public final int VALUE;

    public SampleNAM(int val){
        VALUE = val;
    }


    // final static method
    public static final void test(){
        System.out.println("final test method");
    }

    // non-static
    public void test2(){
        System.out.println("non-static method");
    }

    public static void main(String[] args) {
        SampleNAM s = new SampleNAM(777);
        System.out.println(s.VALUE);
        System.out.println(s.PI);
        SampleNAM.test();
//        SampleNAM.test2(); // can't call non-static method on Class
        s.test2();
    }
}

// Can't inherit final class
/*
class Chield extends SampleNAM {
    public Chield(int val) {
        super(val);
    }
}
*/