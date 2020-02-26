package com.orange.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 13:20
 * 4
 */
public class Person {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Person() {

    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
