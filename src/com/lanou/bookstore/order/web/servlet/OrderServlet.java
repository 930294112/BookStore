package com.lanou.bookstore.order.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.structure.Cart;
import com.lanou.bookstore.cart.structure.CartItem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.order.service.OrderException;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.impl.OrderServiceImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/9/22.
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
    private Order order = new Order();
    private OrderService orderService = new OrderServiceImpl();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //生成订单
        //得到data
        Date date = new Date();
        DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dataFormat.format(date));
        User user = (User) request.getSession().getAttribute("user");
        //得到总价  获取参数
        Double sum = Double.valueOf(request.getParameter("sum"));
        order.setOid(CommonUtils.uuid());
        order.setOrdertime(date);
        order.setState(1);
        order.setUid(user.getUid());
        order.setTotal(sum);
        order.setAddress(null);
        orderService.add(order);

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<OrderItem> orderItemList = new ArrayList<>();
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();
        //遍历cartItemMap  获取map中的对象集  stringCartItemEntry 一个包含key和value的对象集
        for (Map.Entry<String, CartItem> stringCartItemEntry : cartItemMap.entrySet()) {
            String key = stringCartItemEntry.getKey();
            OrderItem orderItem = new OrderItem();
            CartItem cartItem = stringCartItemEntry.getValue();
            int count = cartItem.getCount();
            Double price = Double.valueOf(cartItem.getBook().getPrice());
            orderItem.setIid(CommonUtils.uuid());
            orderItem.setCount(count);
            orderItem.setSubtotal(count * price);
            //oidzai在order中
            orderItem.setOid(order.getOid());
            // key 就是bid
            orderItem.setBid(key);
            //通过bid找到这本书  调用service#findByBid
            Book book = orderService.findByBid(key);

            orderItem.setBook(book);
            //把orderItem加到 orderItemList中,得到了一个orderItem的集合
            orderItemList.add(orderItem);
//            System.out.println(orderItemList);
        }
        order.setOrderItemList(orderItemList);
        //把 orderItemList 添加到数据库
        orderService.addOrderItemList(orderItemList);
        request.setAttribute("order", order);
        cart.clear();
        return "f:/jsps/order/desc.jsp";
    }

    //我的订单
    public String myOrders(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", "登录才能看袄!");
        } else {
            String uid = user.getUid();
            List order = orderService.findByUid(uid);
            request.setAttribute("order", order);
        }
        return "f:/jsps/order/list.jsp";
    }


    //加载订单
    public String load(HttpServletRequest request, HttpServletResponse response) {
        //获取oid
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order", order);
        System.out.println(order);
        return "f:/jsps/order/desc.jsp";
    }

    //支付状态
    public String pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oid = request.getParameter("oid");
        int state2 = 2;
        Integer i = orderService.updateState(state2, oid);
        if (i != 1) {
            request.setAttribute("msg", "付款失败,请重新付款");
            return "f:/jsps/msg.jsp";
        } else {
            return "f:/jsps/order/list.jsp";

        }


    }


    //确认收货
    public String confirm(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");
        int state = 3;
        Integer i = null;
        try {
            i = orderService.confirm(state, oid);
            request.getSession().setAttribute("oid",oid);
        } catch (OrderException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/jsps/msg.jsp";
        }
        if (i != 1) {
            request.setAttribute("msg", "确认订单失败");
            return "f:/jsps/msg.jsp";
        } else {
            //修改订单状态为4
            orderService.updateState(4, oid);
            return "f:/jsps/start.jsp";

        }
    }

    //添加留言
    public  String addContext(HttpServletRequest request,HttpServletResponse response){
       String oid = (String)request.getSession().getAttribute("oid");
       String context = request.getParameter("context");
        System.out.println(context);
        orderService.addContext(context,oid);
        return "f:/jsps/body.jsp";
    }
}
