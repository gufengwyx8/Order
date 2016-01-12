/*
 * @(#)OrderAction.java 2014-4-30 ����08:02:16 Order
 */
package com.order.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.order.model.Category;
import com.order.model.Desk;
import com.order.model.Food;
import com.order.model.OrderDetail;

/**
 * OrderAction
 * @author wang
 * @version 1.0
 *
 */
@Component("orderAction")
@Scope("prototype")
public class OrderAction extends BaseAction {
    private List<Food> car;

    private Food food;

    private List<Food> foodList;

    private Desk desk;

    private List<Desk> deskList;

    private List<Category> categoryList;

    private Category category;

    private OrderDetail order;

    private Double totalPrice;

    public String index() {
        deskList = deskService.listUnused();
        return SUCCESS;
    }

    public String saveDesk() {
        deskService.saveOrUpdate(desk);
        msg = SUCCESS;
        return SUCCESS;
    }

    public String destoryDesk() {
        deskService.delete(desk);
        return SUCCESS;
    }

    public String listCategory() {
        if (desk != null) {
            desk = deskService.getEntityById(desk.getId());
            desk.setUsed(true);
            deskService.update(desk);
            session.put("desk", desk);
        }
        categoryList = categoryService.list();
        return SUCCESS;
    }

    public String saveCategory() {
        categoryService.save(category);
        msg = SUCCESS;
        return SUCCESS;
    }

    public String destoryCategory() {
        categoryService.delete(category);
        return SUCCESS;
    }

    public String listFood() {
        car = (List<Food>) session.get("car");
        if (car == null) {
            session.put("car", new ArrayList<Food>());
        }
        car = (List<Food>) session.get("car");
        totalPrice = 0.0;
        for (Food f : car) {
            totalPrice += f.getPrice();
        }
        foodList = foodService.list(category);
        return SUCCESS;
    }

    public String saveFood() {
        foodService.save(food);
        msg = SUCCESS;
        return SUCCESS;
    }

    public String destoryFood() {
        foodService.delete(food);
        return SUCCESS;
    }

    public String addFood() {
        car = (List<Food>) session.get("car");
        if (car == null) {
            session.put("car", new ArrayList<Food>());
        }
        car = (List<Food>) session.get("car");
        food = foodService.getEntityById(food.getId());
        car.add(food);
        return SUCCESS;
    }

    public String removeFood() {
        car = (List<Food>) session.get("car");
        if (car == null) {
            session.put("car", new ArrayList<Food>());
        }
        car = (List<Food>) session.get("car");
        food = foodService.getEntityById(food.getId());
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).getId().equals(food.getId())) {
                car.remove(i);
                break;
            }
        }
        session.put("car", car);
        return SUCCESS;
    }

    public String addOrder() {
        order = new OrderDetail();
        car = (List<Food>) session.get("car");
        order.setDate(new Date());
        desk = (Desk) session.get("desk");
        order.setDesk(desk);
        order.setFoodList(car);
        totalPrice = 0.0;
        for (Food f : car) {
            totalPrice += f.getPrice();
        }
        order.setPrice(totalPrice);
        orderDetailService.save(order);
        desk.setUsed(false);
        deskService.update(desk);
        session.remove("car");
        session.remove("desk");
        return SUCCESS;
    }
    
    /**
     * ����  car
     * @return car
     */
    public List<Food> getCar() {
        return car;
    }

    /**
     * ���� car
     * @param car car
     */
    public void setCar(List<Food> car) {
        this.car = car;
    }

    /**
     * ����  food
     * @return food
     */
    public Food getFood() {
        return food;
    }

    /**
     * ���� food
     * @param food food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * ����  foodList
     * @return foodList
     */
    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * ���� foodList
     * @param foodList foodList
     */
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    /**
     * ����  desk
     * @return desk
     */
    public Desk getDesk() {
        return desk;
    }

    /**
     * ���� desk
     * @param desk desk
     */
    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    /**
     * ����  deskList
     * @return deskList
     */
    public List<Desk> getDeskList() {
        return deskList;
    }

    /**
     * ���� deskList
     * @param deskList deskList
     */
    public void setDeskList(List<Desk> deskList) {
        this.deskList = deskList;
    }

    /**
     * ����  categoryList
     * @return categoryList
     */
    public List<Category> getCategoryList() {
        return categoryList;
    }

    /**
     * ���� categoryList
     * @param categoryList categoryList
     */
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * ����  category
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * ���� category
     * @param category category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * ����  order
     * @return order
     */
    public OrderDetail getOrder() {
        return order;
    }

    /**
     * ���� order
     * @param order order
     */
    public void setOrder(OrderDetail order) {
        this.order = order;
    }

    /**
     * ����  totalPrice
     * @return totalPrice
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * ���� totalPrice
     * @param totalPrice totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
