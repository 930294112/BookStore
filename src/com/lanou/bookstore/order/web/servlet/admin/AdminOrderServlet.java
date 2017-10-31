package com.lanou.bookstore.order.web.servlet.admin;

import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.impl.OrderServiceImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/26.
 */
@WebServlet("/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {
   private OrderService orderService = new OrderServiceImpl();
    //查看所有订单
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        List orders = orderService.findAll();
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }

    //查看未付款订单
    public String findState1(HttpServletRequest request,HttpServletResponse response){
        int state = 1;
        List orders = orderService.findState(state);
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }
    //查看已经付款没有发货订单
    public String findState2(HttpServletRequest request,HttpServletResponse response){
        int state = 2;
        List orders = orderService.findState(state);
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }

    //发货
    public String send(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        int state=3;
        orderService.updateState(3,oid);
        request.setAttribute("msg","已将发货给买家");
        return "f:/adminjsps/msg.jsp";
    }
    //查看未确认收货订单
    public String findState3(HttpServletRequest request,HttpServletResponse response){
        int state = 3;
        List orders = orderService.findState(state);
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }
    //查看完成订单
    public String findState4(HttpServletRequest request,HttpServletResponse response){
        int state = 4;
        List orders = orderService.findState(state);
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }

}
