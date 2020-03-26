package com.spring_intro.ioc;

import com.spring_intro.entity.Student;

public class Test {
    public static void main(String[] args) {
        // create object via IoC written by myself
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./src/main/resources/spring.xml");
        Student s = (Student) applicationContext.getBean("student");
        System.out.println(s);
    }
}
