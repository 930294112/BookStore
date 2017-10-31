package com.lanou.bookstore.collect.servlet;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.structure.Cart;
import com.lanou.bookstore.cart.structure.CartItem;
import com.lanou.bookstore.collect.domain.Collect;
import com.lanou.bookstore.collect.domain.CollectItem;
import com.lanou.bookstore.collect.service.CollectService;
import com.lanou.bookstore.collect.service.impl.CollectServiceImpl;
import com.lanou.bookstore.order.domain.OrderItem;
import com.lanou.bookstore.user.domain.User;
import com.lanou.commons.CommonUtils;
import com.sun.xml.internal.rngom.parse.host.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/9/29.
 */
@WebServlet("/CollectServlet")
public class CollectServlet extends Base {
    CollectService collectService = new CollectServiceImpl();
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
        Collect collect = new Collect();
        collect.setCcid(CommonUtils.uuid());
        collect.setCtime(date);
        collect.setUid(user.getUid());
        collect.setCtotal(sum);
        collectService.add(collect);

        Cart cart = (Cart) request.getSession().getAttribute("cart1");
        List<CollectItem> collectItemList = new ArrayList<>();
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();
        //遍历cartItemMap  获取map中的对象集  stringCartItemEntry 一个包含key和value的对象集
        for (Map.Entry<String, CartItem> stringCartItemEntry : cartItemMap.entrySet()) {
            String key = stringCartItemEntry.getKey();
            CollectItem collectItem = new CollectItem();
            CartItem cartItem = stringCartItemEntry.getValue();
            int count = cartItem.getCount();
            Double price = Double.valueOf(cartItem.getBook().getPrice());
           collectItem.setIcid(CommonUtils.uuid());
           collectItem.setCount(count);
           collectItem.setSubtotal(count * price);

           collectItem.setCcid(collect.getCcid());
            // key 就是bid
           collectItem.setBid(key);
            //通过bid找到这本书  调用service#findByBid
            Book book = collectService.findByBid(key);
            collectItem.setBook(book);
            collectItemList.add(collectItem);
//
        }
       collect.setCollectItemmList(collectItemList);
        //把 orderItemList 添加到数据库
        collectService.addCollectItemList(collectItemList);
        request.setAttribute("collect", collect);
        cart.clear1();
        return "f:/jsps/collect/desc.jsp";
    }
}
