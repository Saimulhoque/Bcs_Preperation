package com.forbitbd.bcspreperation.model;

import java.io.Serializable;

public class Order implements Serializable {

    private String name;
    private String bangla_name;
    private int order;
    private String type;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBangla_name() {
        return bangla_name;
    }

    public void setBangla_name(String bangla_name) {
        this.bangla_name = bangla_name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
