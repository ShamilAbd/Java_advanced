package pro.shamilabd.basics;

import pro.shamilabd.elementary.Utils;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.04.2023
 */
public class StringBldr {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(16); // default capacity
        StringBuilder sb3 = new StringBuilder("Hello World!");
        StringBuilder sb4 = new StringBuilder("Hello Shoma".subSequence(6,8));
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
        System.out.println(sb4);
        Utils.line();

        StringBuilder eq1 = new StringBuilder("123");
        StringBuilder eq2 = new StringBuilder("123");
        System.out.println(eq1==eq2);
        System.out.println(eq1.equals(eq2)); // not override :-(
        Utils.line();

        sb1.append(1);
        System.out.println(sb1);
        Utils.line();

        sb1.append(new Object());
        System.out.println(sb1);
        Utils.line();

        sb1.append(", Hello");
        System.out.println(sb1);
        Utils.line();

        sb1.append(sb4);
        System.out.println(sb1);
        Utils.line();

        sb1.append("Hello Shoma".subSequence(6,8));
        System.out.println(sb1);
        Utils.line();

        sb1.append(new char[]{',', ' ', 'P', 'r', 'i', 'v', 'e', 't'});
        System.out.println(sb1);
        Utils.line();

        sb1.append(true);
        System.out.println(sb1);
        Utils.line();

        sb1.append('S');
        System.out.println(sb1);
        Utils.line();

        sb1.append(456L);
        System.out.println(sb1);
        Utils.line();

        sb1.append(3.14f);
        System.out.println(sb1);
        Utils.line();

        sb1.append(345.456);
        System.out.println(sb1);
        Utils.line();
        Utils.line();

        StringBuffer sbf = new StringBuffer("SBF");
        sb1.append(sbf);
        System.out.println(sb1);
        Utils.line();

        sb2.append("Hello").append(", Shoma!").append(" ").append(123).append(" This is method chaining");
        System.out.println(sb2);
        Utils.line();

        // Hello World!
        System.out.println(sb3.length());
        System.out.println(sb3.capacity());
        System.out.println(sb3.charAt(0));
        System.out.println(sb3.indexOf("s"));
        System.out.println(sb3.indexOf("d"));
        System.out.println(sb3.indexOf("l", 4));
        System.out.println(sb3.deleteCharAt(6));
        System.out.println(sb3.substring(3,7));
        System.out.println(sb3.delete(8,10));
    }
}
