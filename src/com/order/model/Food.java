/*
 * @(#)Food.java 2014-4-30 ����07:47:58 Order
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
     * ����  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * ���� name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
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
     * ����  category
     * @return category
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    /**
     * ���� category
     * @param category category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
