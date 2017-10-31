package com.lanou.bookstore.book.web.servlet.admin;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    //查询图书
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List booklist = bookService.findAll();
        request.setAttribute("booklist", booklist);
        return "f:/adminjsps/admin/book/list.jsp";
    }

    //加载图书
    public String load(HttpServletRequest request, HttpServletResponse response) {
       String bid =request.getParameter("bid");
        Book book = bookService.load(bid);
        String cid = book.getCid();
        Category category = bookService.findByCid(cid);
        request.setAttribute("book", book);
        request.setAttribute("category", category);

        return "f:/adminjsps/admin/book/desc.jsp";
    }

    //添加图书
    public String addPre(HttpServletRequest request, HttpServletResponse response) {
        List list = bookService.addPre();
        request.setAttribute("list", list);
        return "f:/adminjsps/admin/book/add.jsp";

    }

    //删除图书
    public String del(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        bookService.del(bid);
        List list = bookService.findAll();
        request.setAttribute("list",list);
        return "f:/adminjsps/admin/book/list.jsp";
    }
    //编辑图书
    public String edit(HttpServletRequest request,HttpServletResponse response){
        String image = request.getParameter("image");
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
        System.out.println(book);
        book.setImage(image);
        bookService.edit(book);
        return "f:/adminjsps/admin/book/list.jsp";
    }

}
