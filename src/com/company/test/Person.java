package com.company.test;

import java.io.Serializable;

/**
 * Created by asus on 2017/4/28.
 */
class Person implements Serializable{
    private static final long serialVersionUID = -6412852654889352693L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}