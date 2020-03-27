package com.spring_intro.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private long id;
    private String name;
    private int age;
    // Direct Injection from Address class
    // Inject a set (Addresses) for a bean (Student)
    //private List<Address> addresses;
    private Address address;

}
