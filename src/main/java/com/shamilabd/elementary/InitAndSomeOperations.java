package com.shamilabd.elementary;

import static com.shamilabd.elementary.Utils.line;

public class InitAndSomeOperations {
    public static void main(String[] args) {
        // Варианты объявлений и инициализаций переменных
        int firstValue;
        int testValue = 5;
        int totalValue = testValue;
        int x, y, z;
        int a = 1, b = 127, c, d = testValue;

        // Элементарные арифмитические операции
        totalValue = testValue + 20;
        System.out.println(totalValue);
        totalValue += 25;
        System.out.println(totalValue);
        Utils.line();

        totalValue = totalValue - 20;
        System.out.println(totalValue);
        totalValue -= 10;
        System.out.println(totalValue);
        Utils.line();

        totalValue = totalValue * 2;
        System.out.println(totalValue);
        totalValue *= 3;
        System.out.println(totalValue);
        Utils.line();

        totalValue = 122;
        System.out.println("Division, set totalValue = " + totalValue);
        totalValue = totalValue / 3;
        System.out.println(totalValue); // Still int, without fraction
        totalValue /= 4;
        System.out.println(totalValue);
        Utils.line();

        double dbl = 3.0;
        firstValue = 17;
        System.out.println(firstValue / dbl); // Convert to double, with fraction
        Utils.line();

        // Деление с остатком
        totalValue = totalValue % 6;
        System.out.println(totalValue);
        totalValue %= 3;
        System.out.println(totalValue);
        Utils.line();

        System.out.println("Post and Pre Increment and Decrement");
        System.out.println(totalValue++);
        System.out.println(++totalValue);
        Utils.line();
        System.out.println(totalValue--);
        System.out.println(--totalValue);
        Utils.line();

        a = 5;
        //                 5 - 3  + 4 + 4 + 5
        //                 4   3    4   5
        System.out.println(a-- - --a + ++a + a++ +a); // 15
        b = 8;
        //                 9  - 9  + 11 - 10
        //                 9  - 10 + 11 - 10
        System.out.println(++b - b++ + ++b - --b); // 1
        Utils.line();

        // Булева логика
        testValue = 17;
        System.out.println("firstValue = " + firstValue + " and testValue = " + testValue);
        System.out.println("firstValue > testValue: " + (firstValue > testValue));
        System.out.println("firstValue < testValue: " + (firstValue < testValue));
        System.out.println("firstValue >= testValue: " + (firstValue >= testValue));
        System.out.println("firstValue <= testValue: " + (firstValue <= testValue));
        System.out.println("firstValue == testValue: " + (firstValue == testValue));
        Utils.line();
        System.out.println("firstValue before: " + firstValue);
        System.out.println("(firstValue > 20) && (firstValue++ < 15): " + ((firstValue > 20) && (firstValue++ < 15))); // not incremented
        System.out.println("firstValue after: " + firstValue);
        System.out.println("firstValue before: " + firstValue);
        System.out.println("(firstValue > 20) || (firstValue++ < 15): " + ((firstValue > 20) || (firstValue++ < 15))); // incremented!!!
        System.out.println("firstValue after: " + firstValue);
        line();

        boolean bTrue = true;
        boolean bFalse = false;
        System.out.println("bTrue = " + bTrue + " and bFalse = " + bFalse);
        System.out.println("bTrue && false: " + (bTrue && bFalse));
        System.out.println("bTrue || false: " + (bTrue || bFalse));
        line();
        System.out.println("bTrue & false: " + (bTrue & bFalse));
        System.out.println("bTrue | false: " + (bTrue | bFalse));
        line();
        System.out.println("bTrue ^ false: " + (bTrue ^ bFalse));
        System.out.println("bFalse ^ bTrue: " + (bFalse ^ bTrue));
        System.out.println("bTrue ^ bTrue: " + (bTrue ^ bTrue));
        System.out.println("bFalse ^ false: " + (bFalse ^ bFalse));
        line();
        System.out.println("!bTrue: " + (!bTrue));
        System.out.println("!bFalse: " + (!bFalse));
        line();

        // Работа с байтами
        int b1 = 0b10101;
        int b2 = 0b10101;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("b1 & b2 = " + (b1 & b2));
        System.out.println("b1 | b2 = " + (b1 | b2));
        line();
        b1 = 0b01010;
        b2 = 0b10101;
        //   0b00000 &
        //   0b11111 |
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("b1 & b2 = " + (b1 & b2));
        System.out.println("b1 | b2 = " + (b1 | b2));
        line();
        b1 = 0b01010;
        b2 = 0b10111;
        //   0b00010 &
        //   0b11111 |
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("b1 & b2 = " + (b1 & b2));
        System.out.println("b1 | b2 = " + (b1 | b2));
    }
}
