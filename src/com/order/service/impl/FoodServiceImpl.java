/*
 * @(#)FoodServiceImpl.java 2014-4-30 ÏÂÎç07:55:57 Order
 */
package com.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.order.dao.BaseDao;
import com.order.dao.FoodDao;
import com.order.model.Category;
import com.order.model.Food;
import com.order.service.FoodService;

/**
 * FoodServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("foodService")
public class FoodServiceImpl extends BaseServiceImpl<Food> implements FoodService {

    @Resource(name = "foodDao")
    private FoodDao foodDao;

    @Override
    protected BaseDao<Food> getBaseDao() {
        return foodDao;
    }

    @Override
    public List<Food> list(Category category) {
        return foodDao.list(category);
    }

}
