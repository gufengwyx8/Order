/*
 * @(#)OrderDetailDaoImpl.java 2014-4-30 ÏÂÎç07:54:47 Order
 */
package com.order.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.order.dao.OrderDetailDao;
import com.order.model.OrderDetail;

/**
 * OrderDetailDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail> implements OrderDetailDao {

    @Override
    public List<OrderDetail> listByDay(Date date) {
        String hql = "from OrderDetail where date_format(date,'%Y-%m-%d') = ?";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Object[] params = { df.format(date) };
        return this.list(OrderDetail.class, hql, params);
    }

    @Override
    public List<OrderDetail> listByMonth(Date date) {
        String hql = "from OrderDetail where date_format(date,'%Y-%m') = ?";
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        Object[] params = { df.format(date) };
        return this.list(OrderDetail.class, hql, params);
    }

}
