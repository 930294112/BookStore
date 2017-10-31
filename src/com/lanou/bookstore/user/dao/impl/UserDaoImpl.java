package com.lanou.bookstore.user.dao.impl;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.domain.User;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by dllo on 17/9/21.
 */
public class UserDaoImpl implements UserDao{
    //GxQueryRunner : 获取连接,关闭资源
    private QueryRunner qr = new GxQueryRunner();
    @Override
    public User findWithName(String username) {
        String sql = "select * from tb_user where username=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public User findWithEmail(String email) {
        String sql = "select * from tb_user where email=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(User formUser) {
        String sql = "insert into tb_user values(?,?,?,?,?,?)";
        Object[]params =
                {formUser.getUid(),formUser.getUsername(),formUser.getPassword(),formUser.getEmail(),formUser.getCode(),formUser.getState()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByCode(String code) {
        String sql ="select * from tb_user where code=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),code);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public void updateState(String uid, String state) {
        String sql ="update tb_user set state=1 where uid=?";
        try {
            qr.update(sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
