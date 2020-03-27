package com.spring_intro.test;

import com.spring_intro.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWire {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");

        Person p = (Person) applicationContext.getBean("person");
        System.out.println(p);
    }
}
