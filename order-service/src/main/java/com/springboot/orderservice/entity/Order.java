package com.springboot.orderservice.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author hyhong
 * @since 2020-06-30 17:41:02
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 219921309332200509L;
    
    private Long id;
    //用户id
    private Long userId;
    //产品id
    private Long productId;
    //数量
    private Integer count;
    //金额
    private Double money;
    //订单状态：0：创建中；1：已完结
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}