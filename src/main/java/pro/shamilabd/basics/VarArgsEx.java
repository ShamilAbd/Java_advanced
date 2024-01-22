package pro.shamilabd.basics;

import pro.shamilabd.elementary.Utils;

import java.util.Arrays;

import static pro.shamilabd.basics.ArraysStudy.showArray;
import static pro.shamilabd.elementary.Utils.line;
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.04.2023
 */
public class VarArgsEx {

    //public static void main(String... args) { // we can use ... or []
    public static void main(String[] args) {
        // need run in cmd, and add some params
        // like: java basics.VarArgsEx Hello World
//        learningVarArgs1(args);
//        learningVarArgs2(args);
//        learningVarArgs3(args);
//        ArrayIndOutOfBnds_Example(args);
//        NPE_Example(null);
        varArgsTest(1, true, args);
    }

    public static void learningVarArgs1(String[] args) {
        Utils.line();
        System.out.println(Arrays.toString(args));
        Utils.line();
    }

    public static void learningVarArgs2(String[] args) {
        Utils.line();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + ", ");
        }
        System.out.println("Done.");
        Utils.line();
    }

    public static void learningVarArgs3(String[] args) {
        Utils.line();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].length());
        }
        Utils.line();
    }

    public static void ArrayIndOutOfBnds_Example(String[] args) {
        // if we don't add element, we will take ArrayIndexOutOfBoundsException
        System.out.println(args[0].length());
        Utils.line();
    }

    public static void NPE_Example(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        Utils.line();
    }

    public static void varArgsTest(int num, boolean check, String... args) {
        System.out.println(num);
        System.out.println(check);
        ArraysStudy.showArray(args);
        Utils.line();
    }


}
