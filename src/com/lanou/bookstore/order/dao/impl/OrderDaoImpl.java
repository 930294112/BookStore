package com.lanou.bookstore.order.dao.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dllo on 17/9/22.
 */
public class OrderDaoImpl implements OrderDao{
    QueryRunner qr = new GxQueryRunner();
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
    public void addOrderItemList(List<OrderItem> orderItemList) {
        String sql ="insert into orderitem values(?,?,?,?,?)";
        for (OrderItem orderItem : orderItemList) {
            Object[] params = {orderItem.getIid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getOid(),orderItem.getBid()};
            try {
                qr.update(sql,params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Order order) {
        String sql = "insert into orders(oid,ordertime,total,state,uid,address) values(?,?,?,?,?,?)";
        Object[] params = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),order.getUid(),order.getAddress()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {

        }
    }
// uid-->orders-遍历->order-->orderItems-遍历->orderItem-->book
    @Override
    public List findByUid(String uid) {
        String sql = "select oid,ordertime,total,state,uid,address from orders where uid=? order by ordertime DESC";
        try {
            List<Order> orders = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
            for (Order order : orders) {
                String oid = order.getOid();
                String sql1 = "select * from orderitem where oid=?";
                List<OrderItem> orderItems = qr.query(sql1, new BeanListHandler<OrderItem>(OrderItem.class), oid);
                for (OrderItem orderItem : orderItems) {
                    String bid = orderItem.getBid();
                    String sql2 = "select * from book where bid=?";
                    Book book = qr.query(sql2, new BeanHandler<Book>(Book.class), bid);
                    orderItem.setBook(book);
                }
                order.setOrderItemList(orderItems);
            }
            return orders;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public Order load(String oid) {
        String sql = "select oid,ordertime,total,state,uid,address from orders where oid=?";
        try {
            Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
            String sql1 = "select * from orderitem where oid=?";
            List<OrderItem> orderItems = qr.query(sql1, new BeanListHandler<OrderItem>(OrderItem.class), oid);
            for (OrderItem orderItem : orderItems) {
               String bid = orderItem.getBid();
                String sql2 = "select * from book where bid=?";
                Book book = qr.query(sql2, new BeanHandler<Book>(Book.class), bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItems);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order getStateByOid(String oid) {
        String sql = "select oid,ordertime,total,state,uid,address from orders where oid=?";
        try {
            return qr.query(sql, new BeanHandler<Order>(Order.class), oid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer updateState( Integer state,String oid) {
        String sql ="update orders set state=? where oid=?";

        try {
           return  qr.update(sql, state, oid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAll() {
        String sql = "select oid,ordertime,total,state,uid,address from orders";
        try {
            List<Order> orders = qr.query(sql, new BeanListHandler<Order>(Order.class));
            for (Order order : orders) {
                String oid = order.getOid();
                String sql1 = "select * from orderitem where oid=?";
                List<OrderItem> orderItems = qr.query(sql1, new BeanListHandler<OrderItem>(OrderItem.class), oid);
                for (OrderItem orderItem : orderItems) {
                    String bid = orderItem.getBid();
                    String sql2 = "select * from book where bid=?";
                    Book book = qr.query(sql2, new BeanHandler<Book>(Book.class), bid);
                    orderItem.setBook(book);
                }
                order.setOrderItemList(orderItems);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findState(int state) {
        String sql = "select oid,ordertime,total,state,uid,address from orders where state=?";
        try {
            List<Order> orders = qr.query(sql, new BeanListHandler<Order>(Order.class),state);
            System.out.println(orders);
            for (Order order : orders) {
                String oid = order.getOid();
                String sql1 = "select * from orderitem where oid=?";
                List<OrderItem> orderItems = qr.query(sql1, new BeanListHandler<OrderItem>(OrderItem.class), oid);
                for (OrderItem orderItem : orderItems) {
                    String bid = orderItem.getBid();
                    String sql2 = "select * from book where bid=?";
                    Book book = qr.query(sql2, new BeanHandler<Book>(Book.class), bid);
                    orderItem.setBook(book);
                }
                order.setOrderItemList(orderItems);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addContext(String context,String oid) {
        String sql = "update orders set context=? where oid=?";
        Object[] params = {context,oid};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
