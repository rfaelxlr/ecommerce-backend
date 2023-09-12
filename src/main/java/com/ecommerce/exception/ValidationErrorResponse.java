package com.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Violation {

    private String fieldName;

    private String message;

}
