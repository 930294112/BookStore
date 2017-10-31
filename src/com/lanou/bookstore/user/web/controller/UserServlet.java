package com.lanou.bookstore.user.web.controller;

import com.lanou.bookstore.cart.structure.Cart;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.UserException;
import com.lanou.bookstore.user.service.UserService;
import com.lanou.bookstore.user.service.impl.UserServiceImpl;
import com.lanou.commons.CommonUtils;
import com.lanou.mail.Mail;
import com.lanou.mail.MailUtils;
import com.lanou.servlet.BaseServlet;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by dllo on 17/9/21.
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取请求参数,封装到formUser中
        User formUser = CommonUtils.toBean(request.getParameterMap(), User.class);
        //补全uid,code
        formUser.setUid(CommonUtils.uuid());
        formUser.setCode((CommonUtils.uuid()+CommonUtils.uuid()));

        //输入校验
        int u = formUser.getUsername().length();
        if (u == 0) {
            request.setAttribute("unameError", "用户名不能为空");
            request.getRequestDispatcher("jsps/user/regist.jsp").forward(request, response);
        } else if (u < 3 || u > 15 && u > 0) {
            request.setAttribute("username",formUser.getUsername());
            request.setAttribute("unameError", "用户名长度要在3到15个位之间");
            request.getRequestDispatcher("jsps/user/regist.jsp").forward(request, response);
        }

        int p = formUser.getPassword().length();
        if (p == 0) {
            request.setAttribute("pwdError", "密码不能为空");
            request.getRequestDispatcher("jsps/user/regist.jsp").forward(request, response);
        } else if (p < 3 || p > 15 && p > 0) {
            request.setAttribute("password",formUser.getPassword());
            request.setAttribute("pwdError", "密码长度要在3到15位之间");
            request.getRequestDispatcher("jsps/user/regist.jsp").forward(request, response);
        }
        int e = formUser.getEmail().length();
        if (e == 0) {
            request.setAttribute("emailError", "邮箱不能为空!");
            request.getRequestDispatcher("jsps/user/regist.jsp").forward(request, response);
        }

        //注册当前用户
        //调用service#regist的方法
        try {
            userService.regist(formUser);
            sendMail(formUser);
            request.setAttribute("msg","恭喜您注册成功,请去邮箱激活");
            return "f:jsps/msg.jsp";
        } catch (UserException e1) {
            //保存错误信息
            request.setAttribute("jsps/msg",e1.getMessage());
            //保存数据,用于表单回显\
            request.setAttribute("username",formUser.getUsername());
            request.setAttribute("password",formUser.getPassword());
            request.setAttribute("email",formUser.getEmail());
            //转发到登录界面
            return "f:/jsps/user/regist.jsp";

        }

    }
    //发送邮件
    private void sendMail(User user){
        String code = user.getCode();

        //获得session对象
        Session session = MailUtils.createSession("smtp.163.com","xinrugao@163.com","why1993521");
        //创建一个邮件对象
        Mail mail = new Mail("xinrugao@163.com","15998864466@163.com","激活信息呀",
                "<a href='http://localhost:8080//BookStore/UserServlet?method=active&code="+code+"'>点击激活呀</a>");
        try {
            MailUtils.send(session,mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //用户激活
    public String active(HttpServletRequest request,HttpServletResponse response){
        //获取参数激活码
        String code = request.getParameter("code");
        try {
            userService.active(code);
            request.setAttribute("msg","恭喜您激活成功,请登录");
            return "f:jsps//msg.jsp";
        } catch (UserException e) {
           request.setAttribute("msg",e.getMessage());
            return "f:jsps/msg.jsp";

        }
    }
    //用户登录
    public String login(HttpServletRequest request,HttpServletResponse response){
        User fromuser = CommonUtils.toBean(request.getParameterMap(),User.class);
        try {
            User user = userService.login(fromuser);
            request.getSession().setAttribute("user",user);
            //创建购物车
            Cart cart = new Cart();
            //把购物出HashMap一下,可以使用
            cart.setCartItemMap(new HashMap<>());
            request.getSession().setAttribute("cart",cart);
            Cart cart1 = new Cart();
            cart1.setCartItemMap(new HashMap<>());
            request.getSession().setAttribute("cart1",cart1);
            return "r:/index.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("fromuser",fromuser);
            return "f:jsps/user/login.jsp";
        }
    }
    //退出
    public String quit(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().invalidate();
        return "r:/jsps/top.jsp";
    }

}

