package com.code.buffer.product.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductRequest {


    @NotNull
    @Min(0)
    private Double price;

    @NotBlank
    private String productName;

    @NotNull
    @Min(0)
    private Long quantity;
}
