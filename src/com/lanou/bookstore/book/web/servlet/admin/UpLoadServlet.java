package com.lanou.bookstore.book.web.servlet.admin;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.impl.BookServiceImpl;
import com.lanou.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/9/26.
 */
@WebServlet("/UpLoadServlet")
public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        Book book = new Book();
        try {
            List<FileItem> items = sfu.parseRequest(request);
            //解析request
            String bname= new String(items.get(0).getString().getBytes("iso-8859-1"),"utf-8");
            String price = items.get(2).getString();
            Double p = Double.valueOf(price);
            String author = new String(items.get(3).getString().getBytes("iso-8859-1"),"utf-8");
            String cid = items.get(4).getString();
            System.out.println(cid);
            String image = items.get(1).getString();
            //保存到book中
            book.setBid(CommonUtils.uuid());
            book.setBname(bname);
            book.setAuthor(author);
            book.setPrice(p);
            book.setCid(cid);
            book.setDel(false);

            //上传图片
            FileItem fi = items.get(1);
            //上传路径
            String root = this.getServletContext().getRealPath("/book_img/");
            //获取文件名称
            String fiName = fi.getName();
            //处理文件绝对路径
            int index = fiName.lastIndexOf("/");
            if (index!=-1){
                fiName = fiName.substring(index + 1);
            }
            //处理文件同名
            String savename= CommonUtils.uuid()+"_" + fiName;
            //生成路径
            File dirFile = new File(root);
            //生成目录
            dirFile.mkdir();
            // 创建目录文件
            File desFile = new File(dirFile,savename);
            fi.write(desFile);
            //保存图片地址
            book.setImage("/book_img/" + savename);

            request.setAttribute("book",book);
            BookService bookService = new BookServiceImpl();
            bookService.add(book);
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("/adminjsps/msg.jsp").forward(request,response);

        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
    }
}
