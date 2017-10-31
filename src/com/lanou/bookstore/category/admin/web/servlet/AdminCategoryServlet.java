package com.lanou.bookstore.category.admin.web.servlet;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryException;
import com.lanou.bookstore.category.service.CategoryService;
import com.lanou.bookstore.category.service.impl.CategoryServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
@WebServlet("/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    //查看所有分类
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List list = categoryService.findAll();
        request.setAttribute("list",list);
        return "f:/adminjsps/admin/category/list.jsp";
    }

    //添加分类
    public String add(HttpServletRequest request,HttpServletResponse response){
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
       String cname = category.getCname();
        System.out.println(cname);
        String cid = CommonUtils.uuid();
        categoryService.add(cid,cname);
        List list = categoryService.findAll();
        request.setAttribute("list",list);
        return "f:/adminjsps/admin/category/list.jsp";

    }
    //删除分类
    public String delete(HttpServletRequest request,HttpServletResponse response){
       String cid = request.getParameter("cid");
        Category categoryByCid = categoryService.findCategoryByCid(cid);
       request.setAttribute("c",categoryByCid);

        try {
            categoryService.delete(cid);
            List list = categoryService.findAll();
            request.setAttribute("list",list);
             return "f:/adminjsps/admin/category/list.jsp";
        } catch (CategoryException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/adminjsps/msg.jsp";
        }
    }

    //修改分类
    //加载分类
    public String editPre(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        Category category = categoryService.findCategoryByCid(cid);
        request.setAttribute("category",category);
        return "f:/adminjsps/admin/category/mod.jsp";
    }
    //修改分类
    public String edit(HttpServletRequest request,HttpServletResponse response){
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        categoryService.edit(category);
        List list = categoryService.findAll();
        request.setAttribute("list",list);
        return "f:/adminjsps/admin/category/list.jsp";
    }
}
