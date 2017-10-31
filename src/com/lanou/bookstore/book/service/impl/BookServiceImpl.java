package com.lanou.bookstore.book.service.impl;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.dao.impl.BookDaoImpl;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao= new BookDaoImpl();
    @Override
    public List findAll() {
        List allbook = bookDao.findAll();
        return allbook;
    }

    @Override
    public List findByCategory(String cid) {
        List byCategorybook = bookDao.findByCategory(cid);
        return byCategorybook;
    }

    @Override
    public Book load(String bid) {
        Book load = bookDao.load(bid);
        return load;
    }

    @Override
    public Category findByCid(String cid) {
        Category category = bookDao.findByCid(cid);
        return category;
    }

    @Override
    public List addPre() {
        List list = bookDao.addPre();
        return list;
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void del(String bid) {
        bookDao.del(bid);
    }

    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }
}
