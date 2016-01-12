/*
 * @(#)CategoryServiceImpl.java 2014-4-30 ÏÂÎç07:55:57 Order
 */
package com.order.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.order.dao.BaseDao;
import com.order.dao.CategoryDao;
import com.order.model.Category;
import com.order.service.CategoryService;

/**
 * CategoryServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;

    @Override
    protected BaseDao<Category> getBaseDao() {
        return categoryDao;
    }

}
