package com.lanou.bookstore.order.service.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.dao.impl.OrderDaoImpl;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.order.service.OrderException;
import com.lanou.bookstore.order.service.OrderService;

import java.util.List;

/**
 * Created by dllo on 17/9/22.
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Book findByBid(String key) {
        Book book = orderDao.findByBid(key);
        return book;
    }

    @Override
    public void addOrderItemList(List<OrderItem> orderItemList) {
        orderDao.addOrderItemList(orderItemList);
    }

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public List findByUid(String uid) {
        List orderlist = orderDao.findByUid(uid);
        return orderlist;
    }
    @Override
    public Order load(String oid) {
        Order order = orderDao.load(oid);
        return order;
    }

    @Override
    public List findAll() {
        List oders = orderDao.findAll();
       return oders;


    }

    @Override
    public List findState(int state) {
        List oders = orderDao.findState(state);
        return oders;
    }

    @Override
    public Integer updateState(int state, String oid) {
       return orderDao.updateState(state,oid);
    }

    @Override
    public Integer confirm(int state, String oid) throws OrderException {
        Order order = orderDao.getStateByOid(oid);
        Integer state1 = order.getState();
        if (state1==1){
            throw new OrderException("您还没有付款,拒绝确认收货");
        }else{
            return orderDao.updateState(state,oid);
        }
    }

    @Override
    public void addContext(String context, String oid) {
        orderDao.addContext(context,oid);
    }


}
