package pro.shamilabd.basics.exceptions;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 21.04.2023
 */
public class ExceptionLearning {
    public static void main(String[] args) throws SlabakException {
        /*
        Иерархия в исключениях:
                                            Throwable
                Error (unchecked)                            Exception (checked)
            OutOfMemoryError               RuntimeException (unchecked)         (checked)
            StackOverflowError       ArithmeticException                    InterruptedException
            ThreadDeath              ClassCastException                     ClassNotFoundException
            LinkageError             IllegalArgumentException               IOException
            ...                      NullPointerException                   FileNotFoundException
                                     ...                                    ...
         */
//        throwCheckedTest();
//        throwUncheckedTest();
        byte gradeAtSchool = 5;
        if(gradeAtSchool < 3) {
            throw new SlabakException();
        }
    }

    // Обязан добавить в сигнатуру метода или обработать в try/catch
    public static void throwCheckedTest() throws SlabakException {
        SlabakException slabak = new SlabakException("ну что же вы так!? Возвращайтесь к учебе как можно скорее!");
        throw slabak;
    }

    // не обязан ничего делать.
    public static void throwUncheckedTest() {
        LostMouseAndKeyboardException lostMouseAndKeyboard = new LostMouseAndKeyboardException("ну что же ты такой растяпа! Ищи, и возвращайся к учебе! Срочно!");
        throw lostMouseAndKeyboard;
    }
}

// it is checked exception
class SlabakException extends Exception {
    public SlabakException() {
        super();
    }

    public SlabakException(String message) {
        super("Вы бросили учебу! Слабак! Ну а так же: " + message);
    }
}

// it is unchecked exception
class LostMouseAndKeyboardException extends RuntimeException {
    public LostMouseAndKeyboardException() {
    }

    public LostMouseAndKeyboardException(String message) {
        super("Я потерял мышь и клавиатуру :-( Как теперь без них? " + message);
    }
}