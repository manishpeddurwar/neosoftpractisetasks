package com.code.buffer.product.controller;

import com.code.buffer.product.entity.Product;
import com.code.buffer.product.request.ProductRequest;
import com.code.buffer.product.request.ProductResponse;
import com.code.buffer.product.service.ServiceI;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductContoller {

    @Autowired
    private ServiceI service;

    @PostMapping("/create")
    public ResponseEntity<Long> addProduct(@Valid @RequestBody ProductRequest request) {

        log.info("Created addproduct for controller");

        Long id = service.addProduct(request);

        log.info("Completed addproduct for controller");

        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Product>> addProduct() {

        log.info("Created getAllProducts for controller");

        List<Product> allProducts = service.getAllProducts();

        log.info("Completed getAllProducts for controller");

        return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
    }


    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest req ,@PathVariable Long id) {

        log.info("Created updateProducts for controller");

        Product product = service.updateProduct(req, id);

        log.info("Completed updateProducts for controller");

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<ProductResponse> updateProduct( @PathVariable Long id) {

        log.info("Created getproduct for controller");

        ProductResponse prodcuctById = service.getProdcuctById(id);

        log.info("Completed getproduct for controller");

        return new ResponseEntity<ProductResponse>(prodcuctById, HttpStatus.OK);
    }





}
