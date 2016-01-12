/*
 * @(#)Order.java 2014-4-30 ����07:51:46 Order
 */
package com.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Order
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class OrderDetail {
    private Integer id;

    private List<Food> foodList;

    private User user;

    private Double price;

    private Date date;

    private Desk desk;

    /**
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  foodList
     * @return foodList
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_food", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "food_id"))
    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * ���� foodList
     * @param foodList foodList
     */
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    /**
     * ����  user
     * @return user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
     * ���� user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * ����  price
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * ���� price
     * @param price price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * ����  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * ���� date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * ����  desk
     * @return desk
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desk_id")
    public Desk getDesk() {
        return desk;
    }

    /**
     * ���� desk
     * @param desk desk
     */
    public void setDesk(Desk desk) {
        this.desk = desk;
    }

}
