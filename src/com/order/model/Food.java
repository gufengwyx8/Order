/*
 * @(#)Food.java 2014-4-30 下午07:47:58 Order
 */
package com.order.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Food
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Food {
    private Integer id;

    private String name;

    private Double price;

    private Category category;

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  price
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置 price
     * @param price price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 返回  category
     * @return category
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    /**
     * 设置 category
     * @param category category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
