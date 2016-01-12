/*
 * @(#)Desk.java 2014-4-30 ����07:46:09 Order
 */
package com.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Desk
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Desk {
    private Integer id;

    private String name;

    private boolean used;

    /**
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * ���� name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����  used
     * @return used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * ���� used
     * @param used used
     */
    public void setUsed(boolean used) {
        this.used = used;
    }
}
