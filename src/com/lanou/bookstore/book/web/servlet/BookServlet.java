package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
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
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List allbook = bookService.findAll();
        request.setAttribute("allbook",allbook);
        System.out.println(allbook);
        return "f:/jsps/book/list.jsp";
    }

    public  String findByCategory(HttpServletRequest request,HttpServletResponse response){
        //获得
      String cid = request.getParameter("cid");
        List allbook = bookService.findByCategory(cid);
        request.setAttribute("allbook",allbook);
        System.out.println(allbook);
        return "f:/jsps/book/list.jsp";
    }

    public String load(HttpServletRequest request,HttpServletResponse response){
       String bid = request.getParameter("bid");
        Book load = bookService.load(bid);
        request.setAttribute("load",load);
        return "f:/jsps/book/desc.jsp";
    }
}
