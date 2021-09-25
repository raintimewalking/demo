package com.example.demo.bean;

public class Dog {
    private String name;
    private String age;
    public void sout(){
        System.out.println("p");
    }
    public void walking(){}
    public void eat(){
        System.out.println("eat==========");
    }

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
}
