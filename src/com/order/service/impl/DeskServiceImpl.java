/*
 * @(#)DeskServiceImpl.java 2014-4-30 ÏÂÎç07:55:57 Order
 */
package com.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.order.dao.BaseDao;
import com.order.dao.DeskDao;
import com.order.model.Desk;
import com.order.service.DeskService;

/**
 * DeskServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("deskService")
public class DeskServiceImpl extends BaseServiceImpl<Desk> implements DeskService {

    @Resource(name = "deskDao")
    private DeskDao deskDao;

    @Override
    protected BaseDao<Desk> getBaseDao() {
        return deskDao;
    }

    @Override
    public List<Desk> listUnused() {
        return deskDao.listUnused();
    }

}
