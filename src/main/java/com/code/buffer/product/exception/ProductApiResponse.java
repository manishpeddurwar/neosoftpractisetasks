package com.code.buffer.product.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductApiResponse {

    private String message;

    private int errorCode;
}
