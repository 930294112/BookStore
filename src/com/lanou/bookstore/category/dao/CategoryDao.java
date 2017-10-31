package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public interface CategoryDao {


    List findAll();

    void add(String cid,String cname);

    List findCountByCid(String cid);

    void delete(String cid);

    Category findCategoryByCid(String cid);

    void edit(Category category);
}
