package com.spring.accountservice.entity;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author hyhong
 * @since 2020-06-30 16:43:02
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -67173032556437965L;
    //id
    private Long id;
    //用户id
    private Long userId;
    //总额度
    private Double total;
    //已用余额
    private Double used;
    //剩余可用额度
    private Double residue;


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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public Double getResidue() {
        return residue;
    }

    public void setResidue(Double residue) {
        this.residue = residue;
    }

}