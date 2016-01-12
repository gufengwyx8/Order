/*
 * @(#)FoodDaoImpl.java 2014-4-30 обнГ07:54:47 Order
 */
package com.order.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.order.dao.FoodDao;
import com.order.model.Category;
import com.order.model.Food;

/**
 * FoodDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("foodDao")
public class FoodDaoImpl extends BaseDaoImpl<Food> implements FoodDao {

    @Override
    public List<Food> list(Category category) {
        String hql = "from Food f where f.category = ?";
        Object[] params = { category };
        return this.list(Food.class, hql, params);
    }

}
