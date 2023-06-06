package com.shamilabd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 06.06.2023
 */
public class Annotation {
    public static void main(String[] args) {
//        @Override - обязаны переопределить метод
//        @Deprecated - помечаем метод как не рекомендованный к применению, желательно указать что вместо него использовать.

    }

    @MyAnnotation(field = "test", val = 5)
    public void method() {

    }
}

/*
@Target - к чему может быть применена аннотация
    TYPE - class, interface, enum
    FIELD - поле класса
    METHOD - метод класса
    PARAMETER - параметры метода или конструктора
@Retention - жизненный цикл
    SOURCE - только в исходниках, при компиляции отбрасывается
    CLASS - есть в байт-коде, но нет в рантайме
    RUNTIME - видна в рантайме
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String field();
    int val();
}