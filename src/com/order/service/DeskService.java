/*
 * @(#)DeskDao.java 2014-4-30 обнГ07:54:33 Order
 */
package com.order.service;

import java.util.List;

import com.order.model.Desk;

/**
 * DeskDao
 * @author wang
 * @version 1.0
 *
 */
public interface DeskService extends BaseService<Desk> {
    List<Desk> listUnused();
}
