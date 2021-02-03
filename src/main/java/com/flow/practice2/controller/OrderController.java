//package com.flow.practice2.controller;
//
//import com.flow.practice2.entity.Food;
//import com.flow.practice2.entity.Order;
//import com.flow.practice2.entity.User;
//import com.flow.practice2.service.OrderService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
//
//    private final OrderService orderService;
//
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//
//    @PostMapping("/add")
//    public Order createOrder(@RequestBody List<Food> foodList, @RequestBody User user) {
//        log.info("Received addOrder request with foods: {}, by user: {}.", foodList, user);
//        Order order = orderService.createNewOrder(foodList, user);
//        log.debug("the order is: {}", order);
//        return order;
//    }
//
//}
