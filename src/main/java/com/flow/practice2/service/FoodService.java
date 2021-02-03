package com.flow.practice2.service;

import com.flow.practice2.entity.Food;
import com.flow.practice2.exception.ValidationException;
import com.flow.practice2.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class FoodService {

    @Autowired
    private final FoodRepository foodRepository;

    private static final Logger log = LoggerFactory.getLogger(FoodService.class);

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food createFood(Food fromRequest) throws ValidationException {
        if (fromRequest.getName() == null || fromRequest.getName() == "") {
            throw new ValidationException();
        } else {
            log.info("Creating food based on: {} ...", fromRequest);
            Food result = foodRepository.save(fromRequest);
            return result;
        }
    }

    public Food updateAddress(String foodId, Food food) {
        log.info("Updating food on food id: {}, food: {}", foodId, food);
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        if (optionalFood.isEmpty()) {
            throw new ValidationException();
        }
        Food actualFood = optionalFood.get();
        log.debug("Original food was: {}", actualFood.getName());
        actualFood.setName(food.getName());
        actualFood.setDescription(food.getDescription());
        actualFood.setPrice(food.getPrice());
        Food updated = foodRepository.save(actualFood);
        log.debug("Updated food is: {}", updated);
        return updated;
    }


    public List<Food> listFood(Pageable pageable) {
        log.info("Listing foods (page information: {}) ...", pageable);

        Page<Food> foodPage = foodRepository.findAll(pageable);
        List<Food> foodList = foodPage.getContent();
        log.debug("Total count: {}, total pages: {}", foodPage.getTotalElements(), foodPage.getTotalPages());

        return foodList;
    }

    public List<Food> listFood() {
        log.info("Listing all foods..");
        List<Food> foodList = foodRepository.findAll();
        log.debug("Total count: {}", foodList.size());
        return foodList;
    }

    public Food giveTheFood(String foodId) throws Exception {
        log.info("Received a request on id: {}.", foodId);
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        if (optionalFood.isEmpty()) {
            log.error ("There is no food with id: {}.", foodId);
            throw new Exception();
        }
        Food food = optionalFood.get();
        log.debug("The food for id {} is: {}", foodId, food);
        return food;
    }
}
