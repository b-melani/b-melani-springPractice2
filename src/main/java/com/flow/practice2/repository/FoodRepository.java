package com.flow.practice2.repository;

import com.flow.practice2.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {

    <S extends Food> S save(S s);

    List<Food> findAll();

    Optional<Food> findById(@Param("food_id")String foodId);
}
