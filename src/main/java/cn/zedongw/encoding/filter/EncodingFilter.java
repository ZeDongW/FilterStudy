package cn.zedongw.encoding.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName EncodingFilter
 * @Description 编码处理过滤器类
 * @Version 1.0
 * @date ：Created in 2019/6/21 0021 9:53
 * @modified By：
 */

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");					// POST提交有效
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
