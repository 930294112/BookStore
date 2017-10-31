package com.lanou.bookstore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by dllo on 17/9/25.
 */
@WebFilter(filterName = "AdminServletFilter", urlPatterns = "/AdminCategoryServlet")
public class AdminServletFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
