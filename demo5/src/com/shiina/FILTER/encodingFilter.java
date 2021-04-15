package com.shiina.FILTER;

import javax.servlet.*;
import java.io.IOException;

public class encodingFilter implements Filter {

    String encoding = null;  //字符编码

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");   //获取初始化参数（XML配置）
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(encoding != null){
            servletRequest.setCharacterEncoding(encoding);    //设置request的编码格式
            servletResponse.setContentType("application/json;charset="+encoding);   //设置response字符编码
        }
        filterChain.doFilter(servletRequest, servletResponse);    //传递给下一个过滤器
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
