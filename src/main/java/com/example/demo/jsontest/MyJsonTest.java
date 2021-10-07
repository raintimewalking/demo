package com.example.demo.jsontest;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.util.Iterator;

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
//        String json1 = "{\"name\":\"zhangsan\",\"age\":5,\"sex\":1}";
//        String jsonArr = "[{\"name\":\"zhangsan\",\"age\":5},{\"name\":\"zhangsan\",\"age\":5}]";
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("aa", "11");
        System.out.println(objectNode.toString());
        JsonNode jsonNode = objectMapper.valueToTree(objectNode);
        Iterator<String> stringIterator = jsonNode.fieldNames();

    }

}

