/*
 * @(#)CategoryDaoImpl.java 2014-4-30 обнГ07:54:47 Order
 */
package com.order.dao.impl;

import org.springframework.stereotype.Component;

import com.order.dao.CategoryDao;
import com.order.model.Category;

/**
 * CategoryDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

}
