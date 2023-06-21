package com.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SpringBootTest
public class Test01 {
    @Repeatable(value = Colors.class)
    public @interface Color {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Colors {
        Color[] value();
    }

    @Color("green")
    @Color("blue")
    @Color("red")
    public class RGBColor {
        public RGBColor() {
            System.out.println("rgb");
        }
    }

    @Color("green")
    public class GreenColor {}

    @Test
    public void repeatableAnnotationTest() {
        RGBColor rgbColor = new RGBColor();
        GreenColor greenColor = new GreenColor();

        Colors rgbColors = rgbColor.getClass().getAnnotation(Colors.class);
        Color[] rgbColorArray = rgbColor.getClass().getAnnotationsByType(Color.class);

        Color greenColors = greenColor.getClass().getAnnotation(Color.class);
        Color[] greenColorArray = greenColor.getClass().getAnnotationsByType(Color.class);

        System.out.println("rgbColors : " + rgbColors);
        System.out.println("rgbColorArray : " + rgbColorArray);
        System.out.println("rgbColorArray.length : " + rgbColorArray.length);
        System.out.println("greenColors : " + greenColors);
        System.out.println("greenColorArray : " + greenColorArray);
        System.out.println("greenColorArray.length : " + greenColorArray.length);
    }
}