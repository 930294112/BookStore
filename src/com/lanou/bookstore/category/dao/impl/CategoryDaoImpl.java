package com.lanou.bookstore.category.dao.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.category.dao.CategoryDao;
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
public class CategoryDaoImpl implements CategoryDao{
    QueryRunner qr = new GxQueryRunner();
    @Override
    public List findAll() {
        String sql = "select * from category";
        try {
           return qr.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

    }

    @Override
    public void add(String cid,String cname) {
        String sql = "insert into category values(?,?)";
        Object[]params = {cid,cname};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findCountByCid(String cid) {
        String sql = "select * from book where cid=?";
        try {
           return qr.query(sql,new BeanListHandler<Book>(Book.class),cid);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String cid) {
        String sql = "delete  from category where cid=?";
        Object[]params = {cid};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findCategoryByCid(String cid) {
        String sql = "select * from category where cid=?";
        try {
           return qr.query(sql,new BeanHandler<Category>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(Category category) {
        String sql = "update category set cname=? where cid=? ";
        Object[] params = {category.getCname(),category.getCid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
