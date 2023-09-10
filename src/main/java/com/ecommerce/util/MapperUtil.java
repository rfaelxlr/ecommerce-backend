package com.ecommerce.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
}
