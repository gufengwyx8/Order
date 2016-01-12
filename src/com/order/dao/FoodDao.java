/*
 * @(#)FoodDao.java 2014-4-30 обнГ07:54:33 Order
 */
package com.order.dao;

import java.util.List;

import com.order.model.Category;
import com.order.model.Food;

/**
 * FoodDao
 * @author wang
 * @version 1.0
 *
 */
public interface FoodDao extends BaseDao<Food> {
    List<Food> list(Category category);
}
