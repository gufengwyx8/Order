/*
 * @(#)OrderDetailDao.java 2014-4-30 обнГ07:54:33 Order
 */
package com.order.dao;

import java.util.Date;
import java.util.List;

import com.order.model.OrderDetail;

/**
 * OrderDetailDao
 * @author wang
 * @version 1.0
 *
 */
public interface OrderDetailDao extends BaseDao<OrderDetail> {
    List<OrderDetail> listByDay(Date date);

    List<OrderDetail> listByMonth(Date date);
}
