package com.code.buffer.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@NoArgsConstructor
@Getter
@Setter

public class NoProductFoundException extends  RuntimeException {

    private String message;

    public NoProductFoundException(String message) {
        super(message);
        this.message = message;
    }
}
