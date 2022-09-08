package com.linwu.vue3.api.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyLocalDateJsonSerializer extends JsonSerializer<LocalDate> {
    static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String s = localDate.format(DATE_FORMATTER);
        if("2000-01-01".equals(s)){
            jsonGenerator.writeString("");
        }else{
            jsonGenerator.writeString(s);
        }

    }
}
