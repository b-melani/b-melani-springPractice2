//package com.flow.practice2.service;
//
//import com.flow.practice2.entity.Food;
//import com.flow.practice2.entity.Order;
//import com.flow.practice2.entity.User;
//import com.flow.practice2.exception.ValidationException;
//import com.flow.practice2.repository.OrderRepository;
//import com.flow.practice2.repository.UserRepository;
//import org.hibernate.annotations.GenericGenerator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.GeneratedValue;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Transactional
//public class OrderService {
//
//    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
//
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String orderId;
//
//    private final OrderRepository orderRepository;
//    private final UserRepository userRepository;
//
//    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
//        this.orderRepository = orderRepository;
//        this.userRepository = userRepository;
//    }
//
//
//    public Order createNewOrder(List<Food> foodList, User user) {
//        User tempUser = user;
//        log.info("Creating new order with food: {} by user: {}.", foodList, user);
//        if (foodList.isEmpty() || user == null || foodList == null) {
//            log.error("Foodlist is empty or user is not given");
//            throw new ValidationException();
//        }
//        if (foodList.stream().anyMatch(element -> element.getId().equals(null))) throw new ValidationException();
//        log.error("There is food with no id.");
//        if (user.getId() == null) {
//            tempUser = userRepository.save(user);
//        }
//
//        Order order = new Order();
//        order.setFoods(foodList);
//        order.setOrderedBy(tempUser);
//        orderRepository.save(order);
//        log.debug("The order is: {}", order);
//        return order;
//
//    }
//}
