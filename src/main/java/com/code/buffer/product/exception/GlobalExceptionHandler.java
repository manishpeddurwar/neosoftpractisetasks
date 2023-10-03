package com.code.buffer.product.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoProductFoundException.class)
    public ResponseEntity<ProductApiResponse> NoProductFoundxceptionHandler(NoProductFoundException ex)
    {
        ProductApiResponse response = new ProductApiResponse();
        response.setMessage(ex.getMessage());
        response.setErrorCode(HttpStatus.NOT_FOUND.value());

        //return new ResponseEntity<>(response, HttpStatus.valueOf(response.getErrorCode()));
        return ResponseEntity.status(response.getErrorCode()).body(response);
    }


    @ExceptionHandler(UpdateProductFoundException.class)
    public ResponseEntity<ErrorResponse> updateProductFoundException(UpdateProductFoundException ex){
    return new ResponseEntity<ErrorResponse>(new ErrorResponse().builder()
            .errorMessage(ex.getMessage())
            .errorCode(ex.getErrorCode())
            .build(), HttpStatus.NOT_FOUND);
}



}
