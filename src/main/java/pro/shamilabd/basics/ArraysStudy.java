package pro.shamilabd.basics;

import pro.shamilabd.elementary.Utils;

import java.util.Arrays;

import static pro.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.04.2023
 */
public class ArraysStudy {
    public static void main(String[] args) {
        int[] intArray1 = new int[5];
//        int[] intArray2 = new int[5]{1,2,3,4,5}; // error
        int[] intArray2 = new int[]{1, 2, 3, 4, 5};
        int[] intArray3 = {1, 2, 3}; // можно!
//        intArray4 = {1,2,3}; // нельзя!
        int[] intArray5;
        intArray5 = new int[]{1, 2, 3};

        System.out.println(intArray1); // ugly view
        System.out.println(Arrays.toString(intArray1));
        System.out.println(Arrays.toString(intArray2));
        System.out.println(Arrays.toString(intArray3));
        Utils.line();

        String[] strArr = new String[]{"hello", "world", "Shamil"};
        System.out.println(Arrays.toString(strArr));
        // or use our wrapper
        showArray(strArr);
        Utils.line();

        int[][] intArray4 = new int[5][6];
        System.out.println(Arrays.toString(intArray4)); // :-(
//        System.out.println(Arrays.deepToString(intArray4)); // or
        for (int i = 0; i < intArray4.length; i++) {
            System.out.println(Arrays.toString(intArray4[i]));
        }
        Utils.line();

        int[][] intArray6 = new int[5][];
        intArray6[0] = new int[]{1, 2, 3, 4, 5};
        intArray6[1] = new int[]{1, 2, 3};
        intArray6[2] = new int[]{1};
        intArray6[3] = new int[]{1, 2, 3, 4};
        intArray6[4] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < intArray6.length; i++) {
            showArray(intArray6[i]);
        }
        Utils.line();

        // ArrayIndexOutOfBoundsException
//        for (int i = 0; i < 6; i++) {
//            System.out.println(intArray1[i]); // Index 5 out of bounds for length 5
//        }
//        String[] strArrExc = new String[5];
//        strArrExc[0].length(); // NullPointerException

        int[] sorting = {8, -5, -9, 5, 4, 0, 7, 9, 1, -3, -7, 0, 2, 3};
        showArray(sorting);
        // before sorting - errors
        System.out.println(Arrays.binarySearch(sorting, 9));
        System.out.println(Arrays.binarySearch(sorting, 2));
        System.out.println(Arrays.binarySearch(sorting, 22));

        Arrays.sort(sorting);
        showArray(sorting);
        // after sorting - ok
        System.out.println(Arrays.binarySearch(sorting, 9));
        System.out.println(Arrays.binarySearch(sorting, 2));
        System.out.println(Arrays.binarySearch(sorting, 22));
        Utils.line();

        showSortedMin(sorting);
        showSortedMax(sorting);
        showMinMax(sorting);
//        System.out.println(sorting);

    }

    public static void showArray(Object[] obj) {
        System.out.println(Arrays.toString(obj));
    }
    public static void showArray(int[] obj) {
        System.out.println(Arrays.toString(obj));
    }

    public static void showSortedMin(int[] array){
        System.out.println(array[0]);
    }

    public static void showSortedMax(int[] array){
        System.out.println(array[array.length-1]);
    }

    public static void showMinMax(int[] array){
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min) min = array[i];
            if(array[i] > max) max = array[i];
        }
        System.out.println(min);
        System.out.println(max);
    }
}

class BranchInArray{
    public static void main(String[] args) {
        System.out.println("test");
    }
}