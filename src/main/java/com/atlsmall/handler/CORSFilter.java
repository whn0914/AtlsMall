package com.atlsmall.handler;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sxw on 2015-09-30.
 */
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        res.setHeader("Access-Control-Allow-Origin", "*");
        //允许使用的请求方法，以逗号隔开
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        res.setHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
        //res.setHeader("Access-Control-Allow-Credentials", "true");
        //允许自定义的头部，以逗号隔开，大小写不敏感
        //res.setHeader("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
        //}
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
