/*
 * @(#)ReportAction.java 2014-4-30 下午09:43:48 Order
 */
package com.order.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.order.model.OrderDetail;

/**
 * ReportAction
 * @author wang
 * @version 1.0
 *
 */
@Component("reportAction")
@Scope("prototype")
public class ReportAction extends BaseAction {
    private List<OrderDetail> orderList;

    private Double totalPrice;

    private Date date;

    public String dayReport() {
        if (date != null) {
            totalPrice = 0.0;
            orderList = orderDetailService.listByDay(date);
            for (OrderDetail o : orderList) {
                totalPrice += o.getPrice();
            }
        }
        return SUCCESS;
    }

    public String monthReport() {
        if (date != null) {
            totalPrice = 0.0;
            orderList = orderDetailService.listByMonth(date);
            for (OrderDetail o : orderList) {
                totalPrice += o.getPrice();
            }
        }
        return SUCCESS;
    }

    /**
     * 返回  orderList
     * @return orderList
     */
    public List<OrderDetail> getOrderList() {
        return orderList;
    }

    /**
     * 设置 orderList
     * @param orderList orderList
     */
    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回  totalPrice
     * @return totalPrice
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置 totalPrice
     * @param totalPrice totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
