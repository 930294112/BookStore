package com.lanou.bookstore.collect.service;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.collect.domain.Collect;
import com.lanou.bookstore.collect.domain.CollectItem;

import java.util.List;

/**
 * Created by dllo on 17/9/29.
 */
public interface CollectService {
    void add(Collect collect);

    Book findByBid(String key);

    void addCollectItemList(List<CollectItem> collectItemList);
}
