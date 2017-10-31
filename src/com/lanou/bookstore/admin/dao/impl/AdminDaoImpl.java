package com.lanou.bookstore.admin.dao.impl;

import com.lanou.bookstore.admin.dao.AdminDao;
import com.lanou.bookstore.admin.domain.Admin;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by dllo on 17/9/28.
 */
public class AdminDaoImpl implements AdminDao{
QueryRunner qr = new GxQueryRunner();

    @Override
    public Admin login(Admin fromAdmin) {
        String sql ="select * from admin where aname=? and apwd=?" ;
        String aname = fromAdmin.getAname();
        String apwd = fromAdmin.getApwd();
        Object[]params = {aname,apwd};
        try {
             return  qr.query(sql, new BeanHandler<Admin>(Admin.class), params);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
