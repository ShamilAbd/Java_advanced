package pro.shamilabd.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 06.06.2023
 */
@MyMarkAnn
public class AnnotationTest {
    public static void main(String[] args) throws NoSuchMethodException {
//        Примеры аннотаций:
//        @Override - обязаны переопределить метод
//        @Deprecated - помечаем метод как не рекомендованный к применению, желательно указать что вместо него использовать.

        // Работа с собственными аннотациями
        AnnotationTest testClass = new AnnotationTest();
        Annotation myAnnotation = testClass.getClass().getMethod("method").getAnnotation(MyAnnotation.class);
        MyAnnotation testAnnotation = (MyAnnotation) myAnnotation;
        System.out.println("Field value: " + testAnnotation.field());
        System.out.println("\"Val\" value: " + testAnnotation.val());

        System.out.println("-------------------------");

        RepeatableAnnot[] myRepeat = testClass.getClass().getMethod("otherMethod").getAnnotationsByType(RepeatableAnnot.class);
        for (RepeatableAnnot annot : myRepeat) {
            System.out.println("Name: " + annot.name());
            System.out.println("Repeat: " + annot.repeat());
        }

        System.out.println("-------------------------");

        boolean hasMyMarkAnn = testClass.getClass().isAnnotationPresent(MyMarkAnn.class);
        System.out.println("My class has MyMarkAnn annotation: " + hasMyMarkAnn);
     }

    @MyAnnotation(field = "test", val = 5)
    public void method() {

    }

    @RepeatableAnnot
    @RepeatableAnnot(name = "withName", repeat = 5)
    public void otherMethod() {

    }
}

/*
@Target - к чему может быть применена аннотация
    TYPE - class, interface, enum
    FIELD - поле класса
    METHOD - метод класса
    PARAMETER - параметры метода или конструктора (это не весь список)
@Retention - жизненный цикл
    SOURCE - только в исходниках, при компиляции отбрасывается
    CLASS - есть в байт-коде, но нет в рантайме
    RUNTIME - видна в рантайме
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@Documented
@interface MyAnnotation {
    String field();
    int val();
}

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@Documented
@Repeatable(RepeatableAnnotArr.class)
@interface RepeatableAnnot {
    String name() default "не указан";
    int repeat() default 1;
}

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface RepeatableAnnotArr { // Контейнер для MyAnnotation
    RepeatableAnnot[] value();
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarkAnn {
}