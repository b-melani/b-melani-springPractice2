package com.flow.practice2.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToMany(mappedBy = "orders")
    private List<Food> foods;
    @ManyToOne
    private User orderedBy;

    public String getId() {
        return id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setOrderedBy(User orderedBy) {
        this.orderedBy = orderedBy;
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
