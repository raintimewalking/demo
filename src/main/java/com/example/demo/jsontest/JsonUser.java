package com.example.demo.jsontest;

public class JsonUser {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "JsonUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public JsonUser() {
    }

    public JsonUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}