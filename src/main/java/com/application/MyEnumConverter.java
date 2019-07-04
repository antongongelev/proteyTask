package com.application;

import org.springframework.core.convert.converter.Converter;

public class MyEnumConverter implements Converter<String, Status> {

    @Override
    public Status convert(String source) {
        try {
            return Status.valueOf(source.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }
}
