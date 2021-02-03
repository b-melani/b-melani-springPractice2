package com.flow.practice2.controller;

import com.flow.practice2.configuration.PagingProperties;
import com.flow.practice2.entity.Food;
import com.flow.practice2.exception.ValidationException;
import com.flow.practice2.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private static final Logger log = LoggerFactory.getLogger(FoodController.class);

    private final PagingProperties pagingProperties;

    private final FoodService foodService;

    @Autowired
    public FoodController(PagingProperties pagingProperties, FoodService foodService) {
        this.pagingProperties = pagingProperties;
        this.foodService = foodService;
    }

    @PostMapping("/add")
    public Food addFood(@RequestBody Food food) {
        log.info("Received addFood request {} ...", food);
        try {
            Food result = foodService.createFood(food);
            log.debug("Result is: {}.", result);
            return result;
        } catch (ValidationException e) {
            e.printStackTrace();
            log.error("Error when creating food");
            return null;
        }
    }

    @PutMapping("/updatefood/{id}")
    public Food updateFood(@PathVariable("id") String foodId, @RequestBody Food food) {
        log.info("Received Food update request for id {} with updates: {}", foodId, food);
        try {
            Food updatedFood = foodService.updateAddress(foodId, food);
            log.debug("The updated food is: {}", updatedFood);
            return updatedFood;
        } catch (ValidationException e) {
            log.error("Food with given id ({}) not found.", foodId);
            return null; //??
        }
    }

    @GetMapping("/allfoods")
    public List<Food> getFoods(@RequestParam (value = "page", required = false) Optional<Integer> page,
                               @RequestParam (value = "limit", required = false) Optional<Integer> limit) {

        log.info("Retrieving foods (page: {}, limit: {}) ...", page.isPresent() ? page.get() : "n.a.", limit.orElse(pagingProperties.getDefaultLimit()));
        List<Food> foodList;
        if (page.isPresent()) {
            foodList = foodService.listFood(
                    PageRequest.of(page.get(), limit.orElse(pagingProperties.getDefaultLimit())));
        } else {
            foodList = foodService.listFood();
        }
        log.debug("Found foods: {}", foodList.size());
        return foodList;

    }


}
