package com.shiina.FILTER;

import com.shiina.UTILS.SensitiveWord;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.List;

public class sensitiveWordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 在过滤器中用装饰模式把原装servletRequest的功能增强了
        // 作用：拦截后台调用的getParamter()方法
        MyRequest req = new MyRequest((HttpServletRequest)servletRequest);
        filterChain.doFilter(req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

class MyRequest extends HttpServletRequestWrapper {
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String str = super.getParameter(name);
        List<String> list = SensitiveWord.getWords();
        // 用*代替敏感词汇
        for (String word : list) {
            str = str.replaceAll(word, "*");
        }
        return str;
    }
}
