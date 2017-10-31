package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public interface CategoryService {

    List findAll();


    void add(String cid,String cname);

    List delete(String cid) throws CategoryException;

    Category findCategoryByCid(String cid);

    void edit(Category category);
}
