package com.example.demo.jsontest;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @program: demo
 * @ClassName MyJsonTest
 * @description:
 * @author: lzy
 * @create: 2021-10-05 10:54
 * @Version 1.0
 **/
public class MyJsonTest {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"zhangsan\",\"age\":5}";
        String json1 = "{\"name\":\"zhangsan\",\"age\":5,\"sex\":1}";
        String jsonArr = "[{\"name\":\"zhangsan\",\"age\":5},{\"name\":\"zhangsan\",\"age\":5}]";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule =
                new SimpleModule("JsonUserDeserializer",new Version(3,1,8,
                        null,null,null));
        simpleModule.addDeserializer(JsonUser.class,new JsonUserDeserializer(JsonUser.class));
        objectMapper.registerModule(simpleModule);
        JsonUser jsonUser = objectMapper.readValue(json, JsonUser.class);
        System.out.println(jsonUser);
    }

}

class JsonUser {
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