package com.example.demo.bean;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@ConfigurationProperties(prefix = "person")
@PropertySource(value = "classpath:person.properties")
@Component
public class Person {
//    @Value("${person.name}")
    private String name;
//    @Value("${person.age}")
    private String age;

    private Map<String,String> hashmap;
    private List list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", hashmap=" + hashmap +
                ", list=" + list +
                ", dog=" + dog +
                '}';
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

    public Map<String, String> getHashmap() {
        return hashmap;
    }

    public void setHashmap(Map<String, String> hashmap) {
        this.hashmap = hashmap;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person() {
    }

    public Person(String name, String age, Map<String, String> hashmap, List list, Dog dog) {
        this.name = name;
        this.age = age;
        this.hashmap = hashmap;
        this.list = list;
        this.dog = dog;
    }
}
