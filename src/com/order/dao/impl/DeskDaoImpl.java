/*
 * @(#)DeskDaoImpl.java 2014-4-30 обнГ07:54:47 Order
 */
package com.order.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.order.dao.DeskDao;
import com.order.model.Desk;

/**
 * DeskDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("deskDao")
public class DeskDaoImpl extends BaseDaoImpl<Desk> implements DeskDao {

    @Override
    public List<Desk> listUnused() {
        String hql = "from Desk d where d.used <> true";
        return this.list(Desk.class, hql);
    }

}
