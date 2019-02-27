package com.coinceres.uflodemo.filter;

import com.coinceres.uflodemo.holder.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        RequestHolder.setRequest(req);
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        } finally {
            RequestHolder.remove();
        }
    }

    @Override
    public void destroy() {

    }
}
