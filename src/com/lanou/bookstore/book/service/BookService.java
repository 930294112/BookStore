package com.lanou.bookstore.book.service;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public interface BookService {
    List findAll();

    List findByCategory(String cid);

    Book load(String bid);

    Category findByCid(String cid);

    List addPre();

    void add(Book book);

    void del(String bid);

    void edit(Book book);
}
