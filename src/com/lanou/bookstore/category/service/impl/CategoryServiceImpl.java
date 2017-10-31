package com.lanou.bookstore.category.service.impl;

import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.dao.impl.CategoryDaoImpl;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryException;
import com.lanou.bookstore.category.service.CategoryService;

import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void add(String cid,String cname) {
        categoryDao.add(cid,cname);
    }

    @Override
    public List delete(String cid) throws CategoryException {
        List listbook = categoryDao.findCountByCid(cid);

        if (listbook.size()>0){
            throw new CategoryException("还有书,不能删");
        }else if (listbook.size()==0){
            categoryDao.delete(cid);
        }
       return null;

    }

    @Override
    public Category findCategoryByCid(String cid) {
        Category categoryByCid = categoryDao.findCategoryByCid(cid);
        return categoryByCid;
    }

    @Override
    public void edit(Category category) {
        categoryDao.edit(category);
    }

}
