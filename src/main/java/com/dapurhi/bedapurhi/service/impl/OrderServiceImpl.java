package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.constant.OrderStatus;
import com.dapurhi.bedapurhi.dto.request.OrderItemRequest;
import com.dapurhi.bedapurhi.dto.request.OrderRequest;
import com.dapurhi.bedapurhi.dto.response.OrderResponse;
import com.dapurhi.bedapurhi.entity.Customer;
import com.dapurhi.bedapurhi.entity.Menu;
import com.dapurhi.bedapurhi.entity.Order;
import com.dapurhi.bedapurhi.entity.OrderItem;
import com.dapurhi.bedapurhi.mapper.OrderMapper;
import com.dapurhi.bedapurhi.repository.OrderRepository;
import com.dapurhi.bedapurhi.service.CustomerService;
import com.dapurhi.bedapurhi.service.MenuService;
import com.dapurhi.bedapurhi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MenuService menuService;
    private final CustomerService customerService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Customer customer = null;

        if (orderRequest.getCustomerId() != null && !orderRequest.getCustomerId().isEmpty()) {
            customer = customerService.getCustomerByIdForInternal(orderRequest.getCustomerId());
        }

        Order order = Order.builder()
                .customer(customer)
                .orderNumber(generateOrderNumber())
                .orderStatus(OrderStatus.COMPLETED)
                .paymentMethod(orderRequest.getPaymentMethod())
                .build();

        List<OrderItem> orderItems = new ArrayList<>();
        long totalAmount = 0L;

        for (OrderItemRequest itemRequest : orderRequest.getOrderItems()) {
            Menu menu = menuService.getMenuByIdForInternal(itemRequest.getMenuId());

            if (!menu.getIsActive()){
                throw new RuntimeException("Menu " + menu.getName() + " sedang tidak aktif.");
            }

            long subtotal = menu.getPrice() * itemRequest.getQuantity();
            totalAmount += subtotal;

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .menu(menu)
                    .quantity(itemRequest.getQuantity())
                    .priceAtTransaction(menu.getPrice())
                    .subtotal(subtotal)
                    .build();
            orderItems.add(orderItem);
        }

        order.setTotalAmount(totalAmount);
        order.setOrderItems(orderItems);
        orderRepository.save(order);

        return OrderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toOrderResponse)
                .toList();
    }

    private String generateOrderNumber() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String randomPart = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        return "ORD-" + datePart + "-" + randomPart;
    }
}
