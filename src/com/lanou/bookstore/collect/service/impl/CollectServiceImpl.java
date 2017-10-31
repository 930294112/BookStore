package com.lanou.bookstore.collect.service.impl;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.collect.dao.CollectDao;
import com.lanou.bookstore.collect.dao.impl.CollectDaoImpl;
import com.lanou.bookstore.collect.domain.Collect;
import com.lanou.bookstore.collect.domain.CollectItem;
import com.lanou.bookstore.collect.service.CollectService;

import java.util.List;

/**
 * Created by dllo on 17/9/29.
 */
public class CollectServiceImpl implements CollectService {
    CollectDao collectDao = new CollectDaoImpl();
    @Override
    public void add(Collect collect) {
        collectDao.add(collect);
    }

    @Override
    public Book findByBid(String key) {
        Book book = collectDao.findByBid(key);
        return book;
    }

    @Override
    public void addCollectItemList(List<CollectItem> collectItemList) {
        collectDao.addCollectItemList(collectItemList);
    }
}
