package com.spring_intro.test;

import com.spring_intro.entity.Car;
import com.spring_intro.factory.InstanceCarFactory;
import com.spring_intro.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");

        // static factory
//        Car car = StaticCarFactory.getCar(1L);
//        System.out.println(car);
        Car bmw = (Car) applicationContext.getBean("car1");
        System.out.println(bmw);

        // instance factory
//        InstanceCarFactory instanceCarFactory = new InstanceCarFactory();
//        Car car = instanceCarFactory.getCar(1L);
//        System.out.println(car);
        Car benz = (Car) applicationContext.getBean("car2");
        System.out.println(benz);
    }
}
