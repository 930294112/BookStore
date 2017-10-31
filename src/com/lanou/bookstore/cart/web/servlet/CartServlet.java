package com.lanou.bookstore.cart.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.bookstore.cart.structure.Cart;
import com.lanou.bookstore.cart.structure.CartItem;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dllo on 17/9/22.
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //得到车
        Cart cart =  (Cart)request.getSession().getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();

        //获取表单参数
        String bid = (request.getParameter("bid"));
        int count = Integer.parseInt(request.getParameter("count"));
        System.out.println(bid);
        System.out.println(count);

        Book book = bookService.load(bid);

        //使用book,count 创建CartItem
        CartItem cartItem = new CartItem(count,book);
        cartItemMap.put(bid,cartItem);

        return "f:/jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request,HttpServletResponse response){
        //得到车
        Cart cart =  (Cart)request.getSession().getAttribute("cart");
        cart.clear();
        return "f:/jsps/cart/list.jsp";

    }
    public String delete(HttpServletRequest request,HttpServletResponse response){
        //获取bid
        String  bid = request.getParameter("bid");
        System.out.println(bid);
        //得到车
        Cart cart =  (Cart)request.getSession().getAttribute("cart");
        cart.delete(bid);
        return "f:/jsps/cart/list.jsp";
    }

    //收藏车

    public String collect(HttpServletRequest request, HttpServletResponse response) {
        //得到车
        Cart cart =  (Cart)request.getSession().getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();

        //获取表单参数
        String bid = (request.getParameter("bid"));
        int count = Integer.parseInt(request.getParameter("count"));
        System.out.println(bid);
        System.out.println(count);

        Book book = bookService.load(bid);

        //使用book,count 创建CartItem
        CartItem cartItem = new CartItem(count,book);
        cartItemMap.put(bid,cartItem);

        return "f:/jsps/cart/collect.jsp";

    }

    public String clear1(HttpServletRequest request,HttpServletResponse response){
        //得到车
        Cart cart =  (Cart)request.getSession().getAttribute("cart1");
        cart.clear();
        return "f:/jsps/cart/collect.jsp";

    }
}
