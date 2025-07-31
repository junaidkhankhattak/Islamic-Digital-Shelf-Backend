package com.fyp.islamic_digital_shelf.Apis;

import com.fyp.islamic_digital_shelf.order.bean.OrderRequest;
import com.fyp.islamic_digital_shelf.order.bean.OrderView;
import com.fyp.islamic_digital_shelf.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderView> placeOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.placeOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderView>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}

