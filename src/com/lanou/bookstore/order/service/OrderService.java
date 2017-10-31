package com.lanou.bookstore.order.service;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/9/22.
 */
public interface OrderService {

    Book findByBid(String key);

    void addOrderItemList(List<OrderItem> orderItemList);

    void add(Order order);

    List findByUid(String uid);

    Order load(String oid);

    List findAll();


    List findState(int state);

    Integer updateState(int state, String oid);

    Integer confirm(int state, String oid) throws OrderException;

    void addContext(String context,String oid);
}
