package com.flow.practice2.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private final String id;

    @ManyToMany(mappedBy = "orders")
    private final List<Food> foods;
    @ManyToOne
    private final User orderedBy;

    public Order(String id, List<Food> foods, User orderedBy) {
        this.id = id;
        this.foods = foods;
        this.orderedBy = orderedBy;
    }

    public String getId() {
        return id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", foods=" + foods +
                ", orderedBy=" + orderedBy +
                '}';
    }
}
