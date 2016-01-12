/*
 * @(#)OrderDetailServiceImpl.java 2014-4-30 ÏÂÎç07:55:57 Order
 */
package com.order.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.order.dao.BaseDao;
import com.order.dao.OrderDetailDao;
import com.order.model.OrderDetail;
import com.order.service.OrderDetailService;

/**
 * OrderDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("orderDetailService")
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {

    @Resource(name = "orderDetailDao")
    private OrderDetailDao orderDetailDao;

    @Override
    protected BaseDao<OrderDetail> getBaseDao() {
        return orderDetailDao;
    }

    @Override
    public List<OrderDetail> listByDay(Date date) {
        return orderDetailDao.listByDay(date);
    }

    @Override
    public List<OrderDetail> listByMonth(Date date) {
        return orderDetailDao.listByMonth(date);
    }

}
