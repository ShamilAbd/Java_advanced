package pro.shamilabd.basics;

// It's end-of-line comment
/*
It's multiline comment
 */

// Below is JavaDoc comment
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class VarAndScope {
    int veeeeeeeeeeeeeeeeeeeeeeeeeeeeRyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyLooooooooooooooooooooooooooooooNG_Name = 1; // Can
    int _underScoreVar = 2; // Can
    volatile int var4 = 3;   // Can
    double money;
    int $4654 = 4;  // Can
//    int 4var = 3; // Can't - NumFirst
//    int byte = 5; // Can't - reserved words
    static transient int String = 6; // Can, but very bad practice
    public static final int CONSTANT_NAME = 13;
    int x; // x have default value
    public static int staticInitValue;

    // выполниться только 1 раз при загрузке класса
    static {
        staticInitValue = 15;
    }

    // будет выполняться при каждом создании экземпляра объекта
    {
        x = 15;
    }

    public static void main(String[] args) {
        System.out.println(String); // Work, but very bad idea
        int y; // y doesn't have default value! Need init.
        int z = 5; // local scope
//        z += y; // Not work!
    }
    // here we don't see var "z"

    int d = 1;
    private synchronized strictfp void fakeChangeInt(int d){
        d = 5; // class field d was hidden by local variable d, and class field "d" weren't been change
    }
    // d still 1

}
