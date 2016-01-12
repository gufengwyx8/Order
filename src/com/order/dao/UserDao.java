/*
 * @(#)UserDao.java 2013-4-10 обнГ12:51:22 Order
 */
package com.order.dao;

import java.util.List;

import com.order.model.User;
import com.order.model.UserType;

/**
 * UserDao
 * @author wang
 * @version 1.0
 *
 */
public interface UserDao extends BaseDao<User> {
    User login(User user);

    List<User> list(UserType type);

}
