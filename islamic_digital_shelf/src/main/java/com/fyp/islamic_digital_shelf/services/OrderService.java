package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.order.bean.OrderRequest;
import com.fyp.islamic_digital_shelf.order.bean.OrderView;

import java.util.List;

public interface OrderService {
OrderView placeOrder(OrderRequest request);
List<OrderView> getAllOrders();
}
