package com.code.buffer.product.service;

import com.code.buffer.product.entity.Product;
import com.code.buffer.product.request.ProductRequest;
import com.code.buffer.product.request.ProductResponse;

import java.util.List;

public interface ServiceI {


    public Long addProduct(ProductRequest request);


    public List<Product> getAllProducts();

    public  Product updateProduct(ProductRequest req, Long id);

    public ProductResponse getProdcuctById(Long id);


    public void reduceQuantity(long productId, long quantity);

}