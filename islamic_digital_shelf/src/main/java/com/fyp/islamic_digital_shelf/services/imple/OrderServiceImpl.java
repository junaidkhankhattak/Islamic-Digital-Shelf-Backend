package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.model.Order;
import com.fyp.islamic_digital_shelf.order.bean.OrderRequest;
import com.fyp.islamic_digital_shelf.order.bean.OrderView;
import com.fyp.islamic_digital_shelf.repo.OrderRepo;
import com.fyp.islamic_digital_shelf.services.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public OrderView placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setEmail(request.getEmail());
        order.setAddress(request.getAddress());
        order.setPhone(request.getPhone());
        order.setQuantity(request.getQuantity());
        order.setBookId(request.getBookId()); // ✅ store bookId directly
        order.setOrderDate(LocalDateTime.now());

        Order saved = orderRepo.save(order);

        return convertToView(saved);
    }

    @Override
    public List<OrderView> getAllOrders() {
        return orderRepo.findAll().stream()
                .map(this::convertToView)
                .collect(Collectors.toList());
    }

    private OrderView convertToView(Order order) {
        return new OrderView(
                order.getId(),
                order.getCustomerName(),
                order.getQuantity(),
                order.getAddress(),
                order.getEmail(),
                order.getPhone(),
                order.getOrderDate()
               // order.getBookId() // ✅ Include bookId in the view if needed
        );
    }
}
