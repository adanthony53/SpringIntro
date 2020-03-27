package com.spring_intro.test;

import com.spring_intro.entity.Student;
import com.spring_intro.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // create object via IoC
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        Student student1 = (Student) applicationContext.getBean("student");
//        Student student2 = (Student) applicationContext.getBean("student");
//        System.out.println(student1);
//        System.out.println(student2);
//        // singleton mode, same object, same address in memory
//        System.out.println(student1 == student2); // true
//
//
//        Student student3 = (Student) applicationContext.getBean("student2");
//        Student student4 = (Student) applicationContext.getBean("student2");
//        System.out.println(student3);
//        System.out.println(student4);
//        // prototype mode, diff. object, diff. address in memory
//        System.out.println(student3 == student4); // false

        // constructor with params
//        Student student3 = (Student) applicationContext.getBean("student3");
//        System.out.println(student3);
//
//        // constructor with params with index
//        Student student4 = (Student) applicationContext.getBean("student4");
//        System.out.println(student4);

        // bean inheritance
        // son bean can have more attribute than father bean, but cannot have less
        // otherwise the inheritance cannot be done
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        Student student1 = (Student) applicationContext.getBean("student");
//        Student student_empty = (Student) applicationContext.getBean("student_empty");
//        System.out.println(student1);
//        System.out.println(student_empty);

        // the creation of beans following the order of the xml file
        // In this case, User bean is before Student bean
        // If u want to create Student first, add depends-on to User
        // So the creation of User depends on Student
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-depends.xml");

        // Spring p-namespace
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p-namespace.xml");
//        Student s = (Student) applicationContext.getBean("student");
//        System.out.println(s);
    }
}
