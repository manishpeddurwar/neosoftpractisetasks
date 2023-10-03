package com.neosoft.orderservice.service;

import com.neosoft.orderservice.entity.Order;
import com.neosoft.orderservice.external.client.ProductService;
import com.neosoft.orderservice.repository.OrderRepository;
import com.neosoft.orderservice.request.OrderRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private ProductService  service;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        //Order Entity -> Save the data with Status Order Created
        //Product Service - Block Products (Reduce the Quantity)
        //Payment Service -> Payments -> Success-> COMPLETE, Else
        //CANCELLED

        log.info("Placing Order Request: {}", orderRequest);

        service.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());


        log.info("Placing Order Request: {}", orderRequest);

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        Order savedOrder = repo.save(order);
        log.info("Order Places successfully with Order Id: {}", order.getId());
        return savedOrder.getId();
    }
}
