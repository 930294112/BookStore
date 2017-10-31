package com.lanou.bookstore.book.domain;

import com.lanou.bookstore.category.domain.Category;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/21.
 */
public class Book implements Serializable{
    private String bid;
    private String bname;
    private Double price;
    private String author;
    private String image;
    private String cid;
    private boolean del;

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public Book(String bid, String bname, Double price, String author, String image, String cid, boolean del) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.cid = cid;
        this.del = del;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }




    @Override
    public String toString() {
        return "Book{"       +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }


    public Book() {
    }


}
