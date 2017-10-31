package com.lanou.bookstore.admin.web.controller;

import com.lanou.bookstore.admin.dao.AdminDao;
import com.lanou.bookstore.admin.dao.impl.AdminDaoImpl;
import com.lanou.bookstore.admin.domain.Admin;
import com.lanou.bookstore.admin.service.AdminService;
import com.lanou.bookstore.admin.service.impl.AdminServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dllo on 17/9/28.
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
    private AdminService adminService = new AdminServiceImpl();


    //用户登录
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Admin fromAdmin = CommonUtils.toBean(request.getParameterMap(), Admin.class);
        Admin admin = adminService.login(fromAdmin);
        System.out.println(admin);
        if (admin==null){
            request.setAttribute("msg","信息错误,在给你一次机会");
            return "f:/adminjsps/login.jsp";
        }else {
            return "f:/adminjsps/admin/index.jsp";
        }


    }
}