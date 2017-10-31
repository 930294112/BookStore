package com.lanou.bookstore.admin.service.impl;

import com.lanou.bookstore.admin.dao.AdminDao;
import com.lanou.bookstore.admin.dao.impl.AdminDaoImpl;
import com.lanou.bookstore.admin.domain.Admin;
import com.lanou.bookstore.admin.service.AdminService;

/**
 * Created by dllo on 17/9/28.
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao  adminDao = new AdminDaoImpl();

    @Override
    public Admin login(Admin fromAdmin) {
        Admin admin = adminDao.login(fromAdmin);
        return admin;

    }
}
