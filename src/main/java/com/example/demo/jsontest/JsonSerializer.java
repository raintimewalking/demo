package com.example.demo.jsontest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @program: demo
 * @ClassName JsonSerializer
 * @description:
 * @author: lzy
 * @create: 2021-10-06 18:11
 * @Version 1.0
 **/
public class JsonSerializer extends StdSerializer<JsonUser> {

    public JsonSerializer(Class<JsonUser> t) {
        super(t);
    }

    @Override
    public void serialize(JsonUser value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeStartObject();
        gen.writeStringField("he",value.getName());
        gen.writeNumberField("nu",value.getAge());
        gen.writeEndObject();

    }
}