package com.lanou.bookstore.category.web.servlet;

import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.impl.CategoryServiceImpl;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/21.
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
        private CategoryService categoryService = new CategoryServiceImpl();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List list = categoryService.findAll();
        request.setAttribute("list",list);
        return "f:/jsps/left.jsp";
    }
}
