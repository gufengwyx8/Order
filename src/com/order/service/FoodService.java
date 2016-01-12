/*
 * @(#)FoodDao.java 2014-4-30 обнГ07:54:33 Order
 */
package com.order.service;

import java.util.List;

import com.order.model.Category;
import com.order.model.Food;

/**
 * FoodDao
 * @author wang
 * @version 1.0
 *
 */
public interface FoodService extends BaseService<Food> {
    List<Food> list(Category category);
}
