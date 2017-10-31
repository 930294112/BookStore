package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;

import java.util.List;

/**
 * Created by dllo on 17/9/22.
 */
public interface OrderDao {

    Book findByBid(String key);

    void addOrderItemList(List<OrderItem> orderItemList);

    void add(Order order);

    List findByUid(String uid);

    Order load(String oid);

    Order getStateByOid(String oid);

   Integer updateState( Integer state,String oid);

    List findAll();

    List findState(int state);


    void addContext(String context,String oid);
}
