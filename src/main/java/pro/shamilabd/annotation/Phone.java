package pro.shamilabd.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 06.06.2023
 */
public class Phone {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("pro.shamilabd.annotation.Xiaomi");
        Annotation annotation = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation;
        System.out.println(sm1.OS());
        System.out.println(sm1.year());

        Class<IPhone> iPhoneClass = (Class<IPhone>) Class.forName("pro.shamilabd.annotation.IPhone");
        Annotation annotation1 = iPhoneClass.getAnnotation(SmartPhone.class);
        SmartPhone iphone = (SmartPhone) annotation1;
        System.out.println(iphone.OS());
        System.out.println(iphone.year());
    }
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String OS() default "Android";
    int year();
//    StringBuilder sb(); // Invalid type 'StringBuilder' for annotation member
    // только примитивы, массивы и String.
}

@SmartPhone(year = 2007)
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", year = 1995)
class IPhone {
    String model;
    double price;
}
