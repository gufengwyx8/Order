/*
 * @(#)UserService.java 2013-4-10 обнГ12:51:33 Order
 */
package com.order.service;

import java.util.List;

import com.order.model.User;
import com.order.model.UserType;

/**
 * UserService
 * @author wang
 * @version 1.0
 *
 */
public interface UserService extends BaseService<User> {
    User login(User user);

    void regUser(User user);

    List<User> list(UserType type);
}
