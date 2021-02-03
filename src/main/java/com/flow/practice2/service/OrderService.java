package com.flow.practice2.service;

import com.flow.practice2.entity.Food;
import com.flow.practice2.entity.Order;
import com.flow.practice2.entity.User;
import com.flow.practice2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveIt(List<Food> foodList, User orderer) {
        Order answer = new Order();
        answer.setFoods(foodList);
        answer.setOrderedBy(orderer);
        return answer;
    }
}
