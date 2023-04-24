package com.shamilabd;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.04.2023
 */
public class Utils {
    private Utils(){}

    public static void line(){
        System.out.println("----------------------------------------");
    }

    public static void line(boolean addNewLineBefore){
        if(addNewLineBefore){
            System.out.println();
        }
        line();
    }
}
