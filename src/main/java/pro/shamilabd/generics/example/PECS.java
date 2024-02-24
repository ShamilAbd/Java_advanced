package pro.shamilabd.generics.example;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {
        List<Number> numbersList = new ArrayList<>();
        List<? extends Number> extendNumList = new ArrayList<>();
        List<? super Number> superNumList = new ArrayList<>();

        List<Number> otherNumList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        List<Integer> integersList = new ArrayList<>();
        List<? extends Number> extendsNum = new ArrayList<>();
        List<? super Number> superNum = new ArrayList<>();

        numbersList = otherNumList; // List<Number> -> List<Number>  - OK
//        numbersList = objList;  // List<Number> -> List<Object>  - BAD
//        numbersList = integersList; // List<Number> -> List<Integer> - BAD
//        numbersList = extendsNum; // List<Number> -> List<? extends Number> - BAD
//        numbersList = superNum; // List<Number> -> List<? super Number>   - BAD

//        extendNumList = objList;  // List<? extends Number> -> List<Object>  - BAD
        extendNumList = otherNumList; // List<? extends Number> -> List<Number>  - OK
        extendNumList = integersList; // List<? extends Number> -> List<Integer> - OK
        extendNumList = extendsNum; // List<? extends Number> -> List<? extends Number> - OK
//        extendNumList = superNum; // List<? extends Number> -> List<? super Number>   - BAD

        superNumList = objList;  // List<? super Number> -> List<Object>  - OK
        superNumList = otherNumList; // List<? super Number> -> List<Number>  - OK
//        superNumList = integersList; // List<? super Number> -> List<Integer> - BAD
//        superNumList = extendsNum; // List<? super Number> -> List<? extends Number> - BAD
        superNumList = superNum; // List<? super Number> -> List<? super Number>   - OK

        Number numberVal = 13.5;
        Object objectVal = new Object();
        Integer integerVal = 7;

        numbersList.add(numberVal);  // OK      Базовый тип и наследников
        numbersList.add(integerVal); // OK
//        numbersList.add(objectVal);  // BAD

//        extendNumList.add(numberVal);  // BAD   НИЧЕГО!
//        extendNumList.add(integerVal); // BAD
//        extendNumList.add(objectVal);  // BAD

        superNumList.add(numberVal);  // OK     Базовый тип и наследников
        superNumList.add(integerVal); // OK
//        superNumList.add(objectVal);  // BAD

        Object obj1 = numbersList.get(0);  // OK     Базовый тип и суперклассы
        Number num1 = numbersList.get(0);  // OK
//        Integer int1 = numbersList.get(0); // BAD

        // Закомментил, т.к. получим IndexOutOfBoundsException из-за того, что ничего не добавили.
//        Object obj2 = extendNumList.get(0);  // OK   Базовый тип и суперклассы
//        Number num2 = extendNumList.get(0);  // OK
//        Integer int2 = extendNumList.get(0); // BAD

        Object obj3 = superNumList.get(0);  // OK    Только Object и ничего больше
//        Number num3 = superNumList.get(0);  // BAD
//        Integer int3 = superNumList.get(0); // BAD
    }
}
