package com.shamilabd.elementary;

public class Utils {
    public static void line() {
        // Для удобства отображения добавим вывод в консоль линии из тире и оформим в виде статического метода с коротким именем
        System.out.println("-------------------------------------");
    }

    public static void line(boolean addNewLineBefore) {
        if (addNewLineBefore) {
            System.out.println();
        }
        line();
    }
}