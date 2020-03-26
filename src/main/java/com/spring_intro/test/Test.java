package com.spring_intro.test;

import com.spring_intro.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // create object via IoC
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);


        //Student student2 = (Student) applicationContext.getBean(Student.class);
        //System.out.println(student2);

        // constructor with params
        Student student3 = (Student) applicationContext.getBean("student3");
        System.out.println(student3);

        // constructor with params with index
        Student student4 = (Student) applicationContext.getBean("student4");
        System.out.println(student4);


    }
}
