package com.spring_intro.test;

import com.spring_intro.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // traditional way to create object
        // Student s = new Student();
        // s.setId(1L);
        // s.setAge(20);
        // s.setName("John Doe");
        // System.out.println(s);

        // create object via IoC
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);

        //425-626-4050
    }
}
