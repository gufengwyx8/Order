/*
 * @(#)HomeAction.java 2013-10-19 ����12:54:08 Logistics
 */
package com.order.action;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * HomeAction
 * @author wang
 * @version 1.0
 *
 */
@Component("homeAction")
@Scope("prototype")
public class HomeAction extends BaseAction {

    private String newPassword1, newPassword2, oldPassword;


    public String index() {
        return SUCCESS;
    }

    public String reg() {
        if (user == null) {
            return INPUT;
        }
        if (!StringUtils.equals(newPassword1, newPassword2)) {
            msg = "���벻һ��";
            return ERROR;
        }
        user.setPassword(newPassword1);
        userService.regUser(user);
        return SUCCESS;
    }

    public String login() {
        if (user == null) {
            return INPUT;
        }
        loginUser = userService.login(user);
        if (loginUser == null) {
            msg = "�������";
            return ERROR;
        }
        return SUCCESS;
    }

    public String password() {
        if (!loginUser.getPassword().equals(oldPassword)) {
            msg = "old error";
            return SUCCESS;
        }
        if (!StringUtils.equals(newPassword1, newPassword2)) {
            msg = "new error";
            return SUCCESS;
        }
        loginUser.setPassword(newPassword1);
        userService.update(loginUser);
        return SUCCESS;
    }

    public String logout() {
        loginUser = null;
        return SUCCESS;
    }

    /**
     * ����  newPassword1
     * @return newPassword1
     */
    public String getNewPassword1() {
        return newPassword1;
    }

    /**
     * ���� newPassword1
     * @param newPassword1 newPassword1
     */
    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    /**
     * ����  newPassword2
     * @return newPassword2
     */
    public String getNewPassword2() {
        return newPassword2;
    }

    /**
     * ���� newPassword2
     * @param newPassword2 newPassword2
     */
    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    /**
     * ����  oldPassword
     * @return oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * ���� oldPassword
     * @param oldPassword oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

}
