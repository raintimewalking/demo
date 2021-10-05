package com.example.demo.jsontest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @program: demo
 * @ClassName JsonUserDeserializer
 * @description:
 * @author: lzy
 * @create: 2021-10-05 12:10
 * @Version 1.0
 **/
public class JsonUserDeserializer extends StdDeserializer<JsonUser> {


    protected JsonUserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public JsonUser deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonUser jsonUser = new JsonUser();
        while (!p.isClosed()){
            JsonToken jsonToken = p.nextToken();
            if(JsonToken.FIELD_NAME.equals(jsonToken)){

                JsonToken jsonToken1 = p.nextToken();
                String currentName = p.getCurrentName();
                if ("name".equals(currentName)){
                    jsonUser.setName(p.getValueAsString());
                }else if ("age".equals(currentName)){
                    jsonUser.setAge(p.getValueAsInt());
                }
            }
        }

        return jsonUser;

    }
}