package com.flow.practice2.controller;

import com.flow.practice2.entity.Food;
import com.flow.practice2.entity.Order;
import com.flow.practice2.exception.ValidationException;
import com.flow.practice2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order prototypeOrder) {
        try {
            return orderService.saveIt(prototypeOrder.getFoods(), prototypeOrder.getOrderedBy());
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(e.getHttpStatus());
        }
    }
}
