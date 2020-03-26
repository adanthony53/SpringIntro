package com.spring_intro.entity;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private int age;
    private Address address; // Direct Injection from Address class
}
