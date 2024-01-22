package pro.shamilabd.generics;

import java.util.ArrayList;
import java.util.List;

public class RowType {
    public static void main(String[] args) {
        // row type can include any object, non type safe
        List rowType = new ArrayList<>();
        rowType.add(1);
        rowType.add(3.14);
        rowType.add("String");
        rowType.add(new Object());
    }
}
