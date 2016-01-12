/*
 * @(#)User.java 2013-4-10 ����12:51:27 Order
 */
package com.order.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * User
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class User {

    private Integer id;

    private String name;

    private String password;

    public UserType type;

    @Transient
    public String getTypeName() {
        if (type == UserType.ADMIN) {
            return "����Ա";
        } else if (type == UserType.USER) {
            return "����Ա";
        }
        return null;
    }

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
     * ����  password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * ���� password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ����  type
     * @return type
     */
    @Enumerated(EnumType.STRING)
    public UserType getType() {
        return type;
    }

    /**
     * ���� type
     * @param type type
     */
    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        return this.getId().equals(u.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() * 31;
    }

}
