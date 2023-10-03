package com.code.buffer.product.service;

import com.code.buffer.product.entity.Product;
import com.code.buffer.product.exception.NoProductFoundException;
import com.code.buffer.product.exception.UpdateProductFoundException;
import com.code.buffer.product.repository.ProductRepository;
import com.code.buffer.product.request.ProductRequest;
import com.code.buffer.product.request.ProductResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ServiceImp implements ServiceI {

    @Autowired
    private ProductRepository repo;

    @Override
    public Long addProduct(ProductRequest request) {

        log.info("Created addproduct for service");

        Product product = Product.builder().
                productName(request.getProductName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        Product save = repo.save(product);
        log.info("Completed saveproduct for service");
        return save.getId();
    }

    @Override
    public List<Product> getAllProducts() {

        log.info("Created getallproduct for service");

        List<Product> allProducts = repo.findAll();

        log.info("Completed getallproduct for service");

        return allProducts;
    }


    public Product updateProduct(ProductRequest req, Long id) {

        log.info("Created updateproduct for service");

        Optional<Product> byId = repo.findById(id);

        if (byId.isPresent()) {
            Product product = byId.get();
            product.setProductName(req.getProductName());
            product.setPrice(req.getPrice());
            product.setQuantity(req.getQuantity());

            log.info("Completed updateproduct for service");
            return repo.save(product);
        } else {
            return null;
        }
    }

    @Override
    public ProductResponse getProdcuctById(Long id) {

        Product product = repo.findById(id).orElseThrow(() -> new NoProductFoundException("Product not found"));

        ProductResponse response = new ProductResponse();

        BeanUtils.copyProperties(product,response);

        return response;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity, productId);

        Product product
                = repo.findById(productId)
                .orElseThrow(() -> new UpdateProductFoundException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));

        if (product.getQuantity() < quantity) {
            throw new UpdateProductFoundException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        repo.save(product);
        log.info("Product Quantity updated Successfully");
    }

    }


