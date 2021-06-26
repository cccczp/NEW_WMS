package com.zorax.wms.instore.dto;

import java.util.Date;

/**
 * @创作者 czp
 * @创作时间 2021/6/25 16:10
 * @描述
 */
public class InstoreBean {
    private String orderNo;

    private String asn;

    private String orderType;

    private String orderDate;

    private String shipper;

    private int quantity;

    public String getOrderNo() {
        return orderNo;
    }

    public InstoreBean setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getAsn() {
        return asn;
    }

    public InstoreBean setAsn(String asn) {
        this.asn = asn;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public InstoreBean setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public InstoreBean setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getShipper() {
        return shipper;
    }

    public InstoreBean setShipper(String shipper) {
        this.shipper = shipper;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public InstoreBean setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "InstoreBean{" +
                "orderNo='" + orderNo + '\'' +
                ", asn='" + asn + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", shipper='" + shipper + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
