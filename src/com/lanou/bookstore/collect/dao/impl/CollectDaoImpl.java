package com.lanou.bookstore.collect.dao.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.collect.dao.CollectDao;
import com.lanou.bookstore.collect.domain.Collect;
import com.lanou.bookstore.collect.domain.CollectItem;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dllo on 17/9/29.
 */
public class CollectDaoImpl implements CollectDao {
    QueryRunner qr = new GxQueryRunner();

    @Override
    public void add(Collect collect) {
        String sql = "insert into collect values(?,?,?,?)";
        Object[] params = {collect.getCcid(), collect.getCtime(), collect.getCtotal(), collect.getUid()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book findByBid(String key) {
        String sql = "select * from book where bid=?";
            try {
                return qr.query(sql,new BeanHandler<Book>(Book.class),key);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void addCollectItemList(List<CollectItem> collectItemList) {
        String sql ="insert into collectitem values(?,?,?,?,?)";
        for (CollectItem collectItem : collectItemList) {
            Object[] params = {collectItem.getIcid(),collectItem.getCount(),collectItem.getSubtotal(),collectItem.getBid(),collectItem.getCcid()};
            try {
                qr.update(sql,params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
