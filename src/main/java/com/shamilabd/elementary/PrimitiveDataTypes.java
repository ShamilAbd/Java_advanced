package com.shamilabd.elementary;

public class PrimitiveDataTypes {

    public static void main(String[] args) {
        byte varByte = 127; // from -128 to 127
        short varShort = 32767; // from -32768 to 32767
        int varInt = 2147483647; // from -2 147 483 648 to 2 147 483 647
        long varLong = 9_223_372_036_854_775_807L; // дофига и больше =)  from -9223372036854775808 to 9223372036854775807
        float varFloat = 3.4028235E38f; // from 1.4E-45 to 3.4028235E38
        double varDouble = 1.7976931348623157E308; // from 4.9E-324 to 1.7976931348623157E308
        char varChar = 65535; // from 0 to 65535
        boolean varBoolean = true; // only true or false
        Utils.line();

        System.out.println("Dec and Hex: " + (12 == 0xC));
        System.out.println("Dec and Bin: " + (12 == 0b1100));
        System.out.println("Dec and Oct: " + (12 == 014));
        Utils.line();

        System.out.println("Byte range is from " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        Utils.line();
        System.out.println("Short range is from " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        Utils.line();
        System.out.println("Integer range is from " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        Utils.line();
        System.out.println("Long range is from " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        Utils.line();
        System.out.println("Float range is from " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        Utils.line();
        System.out.println("Double range is from " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        Utils.line();
        System.out.println("Character range is from " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);
        Utils.line();
        System.out.println("boolean range is from false to true");
        Utils.line();
//      System.out.println(Boolean.MAX_VALUE); // doesn't exists
//      System.out.println(Boolean.MIN_VALUE); // doesn't exists

        // Меньший тип можно поместить в больший без потери
        varShort = varByte;
        varInt = varShort;
        varLong = varInt;
        varFloat = varLong;
        varDouble = varFloat;
        varInt = varChar;
        //varBoolean - никуда :(

        //Рассмотрим подробнее char
        char c1 = 'S';
        char c2 = 83;
        char c3 = '\u0053';
        System.out.println("Sumbol \"S\" as char: " + c1 + ", as int: " + c2 + ", and as Unicode: " + c3);
        Utils.line();
        // до 0x20 идут управляющие символы, их не будем смотреть
//        for (int i = 0x20; i < Character.MAX_VALUE; i++) {
//            String formattedView = String.format("%05d - %-5s", i, (char) i);
//            System.out.print(formattedView);
//            if (i % 10 == 0) System.out.println();
//        }
//        line(true);
        // Выведем отдельно Русские буквы от А до я
        for (int i = 1040; i <= 1103; i++) {
            String formattedView = String.format("%05d - %-5s", i, (char) i);
            System.out.print(formattedView);
            if (i % 11 == 0) System.out.println();
        }
    }

}
