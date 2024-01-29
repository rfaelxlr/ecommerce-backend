package com.ecommerce.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    public static ModelMapper modelMapper = new ModelMapper();

    public <T> T convert(Object object, Class<T> clas) {
        if (object == null)
            return null;

        return modelMapper.map(object, clas);
    }

    public <S, T> List<T> convertList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <T> T mapFromJson(String json, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(StringEscapeUtils.unescapeJson(json), clazz);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
