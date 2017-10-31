package com.lanou.bookstore.order.domain;



import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/9/22.
 */
public class Order {
    private String oid;
    private Date ordertime;
    private double total;
    private Integer state;
    private String uid;
    private String address;
    private List<OrderItem> orderItemList;
    private Text context;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                ", orderItemList=" + orderItemList +
                ", context=" + context +
                '}';
    }

    public Order() {
    }

    public String getOid() {

        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Text getContext() {
        return context;
    }

    public void setContext(Text context) {
        this.context = context;
    }

    public Order(String oid, Date ordertime, double total, Integer state, String uid, String address, List<OrderItem> orderItemList, Text context) {

        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.uid = uid;
        this.address = address;
        this.orderItemList = orderItemList;
        this.context = context;
    }
}
