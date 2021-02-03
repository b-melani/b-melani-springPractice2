package com.flow.practice2.repository;

import com.flow.practice2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

   <S extends Order> S save(S s);

    List<Order> findAll();

    Optional<Order> findById(@Param("order_id") String orderId);
}
