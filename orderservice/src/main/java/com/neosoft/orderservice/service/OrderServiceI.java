package com.neosoft.orderservice.service;

import com.neosoft.orderservice.request.OrderRequest;
import org.springframework.stereotype.Service;


public interface OrderServiceI {


   public long placeOrder(OrderRequest orderRequest);
}


