package com.flow.practice2.service;

import com.flow.practice2.entity.Food;
import com.flow.practice2.entity.Order;
import com.flow.practice2.entity.User;
import com.flow.practice2.exception.ValidationException;
import com.flow.practice2.repository.OrderRepository;
import com.flow.practice2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }
    public Order saveIt(List<Food> foodList, User orderer) throws ValidationException {
        Objects.requireNonNull(foodList);
        Objects.requireNonNull(orderer);
        if (foodList.isEmpty()) {
            throw new ValidationException("Nincs kaja", HttpStatus.BAD_REQUEST);
        }
        User tempUser = orderer;
        for (Food oneFood : foodList
        ) {
            if (oneFood.getId() == null) {
                throw new ValidationException("Nincs kaja ID", HttpStatus.BAD_REQUEST);
            }
        }
        // if (foodList.stream().anyMatch(element -> element.getId() == null)) throw new ValidationException();
        if (orderer.getId() == null) {
            tempUser = userRepository.save(orderer);
        }
        Order answer = new Order();
        answer.setFoods(foodList);
        answer.setOrderedBy(orderer);
        return answer;
    }
}
