package com.lanou.bookstore.cart.structure;

import com.lanou.bookstore.book.domain.Book;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/22.
 */
public class CartItem implements Serializable{
    private int count;
    private Book book;

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "count=" + count +
                ", book=" + book +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CartItem(int count, Book book) {
        this.count = count;
        this.book = book;
    }
}
