package com.lanou.bookstore.collect.domain;

import com.lanou.bookstore.book.domain.Book;

/**
 * Created by dllo on 17/9/29.
 */
public class CollectItem {
    private String icid;
    private Integer count;
    private Double subtotal;
    private String ccid;
    private String bid;
    private Book book;

    public CollectItem() {
    }

    @Override
    public String toString() {
        return "CollectItem{" +
                "icid='" + icid + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", ccid='" + ccid + '\'' +
                ", bid='" + bid + '\'' +
                ", book=" + book +
                '}';
    }

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CollectItem(String icid, Integer count, Double subtotal, String ccid, String bid, Book book) {

        this.icid = icid;
        this.count = count;
        this.subtotal = subtotal;
        this.ccid = ccid;
        this.bid = bid;
        this.book = book;
    }
}
