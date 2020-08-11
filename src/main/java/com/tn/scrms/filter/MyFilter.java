package com.tn.scrms.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: yangcs
 * @Date: 2020/8/11 9:00
 * @Description:
 */
@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>>>>>>>  myFilter is  init.............");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(">>>>>>>>  myFilter is  doFilter.............");
    }

    @Override
    public void destroy() {
        System.out.println(">>>>>>>>  myFilter is  destroy.............");
    }
}
