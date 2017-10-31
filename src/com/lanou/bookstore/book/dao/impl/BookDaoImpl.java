package com.lanou.bookstore.book.dao.impl;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public class BookDaoImpl implements BookDao {
    QueryRunner qr = new GxQueryRunner();
    @Override
    public List findAll() {
        String sql = "select * from book where del=0";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findByCategory(String cid) {
        String sql = "select * from book where cid=? and del=0";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book load(String bid) {
        String sql = "select * from book where bid=? and del=0";
        try {
            return qr.query(sql,new BeanHandler<Book>(Book.class),bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findByCid(String cid) {
        String sql = "select * from category where cid=? ";
        try {
            return qr.query(sql,new BeanHandler<Category>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List addPre() {
        String sql ="select * from category";
        try {
             return  qr.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Book book) {
        String sql = "insert into book values(?,?,?,?,?,?,?)";
        Object[]params={book.getBid(),book.getBname(),book.getPrice(),
                book.getAuthor(),book.getImage(),book.getCid(),book.isDel()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void del(String bid) {
        String sql = "update book set del=true where bid=?";
        try {
            qr.update(sql,bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Book book) {
        String sql ="update book set bname=?,price=?,author=?,cid=? where image=?";
        Object[]params = {book.getBname(),book.getPrice(),book.getAuthor(),book.getCid(),book.getImage()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
