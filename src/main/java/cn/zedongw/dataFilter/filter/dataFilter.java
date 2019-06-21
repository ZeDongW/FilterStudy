package cn.zedongw.dataFilter.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZeDongW
 * @ClassName DataFilter
 * @Description 无效数据过滤
 * @Version 1.0
 * @date ：Created in 2019/6/21 0021 11:26
 * @modified By：
 */

public class dataFilter implements Filter {
    //屏蔽无效数据
    private List<String> list;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化无效数据
        list = new ArrayList<>();
        list.add("MD");
        list.add("NND");
        list.add("共产党");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;

        //设置代理对象
        HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(
                HttpServletRequest.class.getClassLoader(),
                new Class[]{HttpServletRequest.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //定义方法返回值
                        Object returnValue;
                        //获取方法名
                        String methodName = method.getName();
                        //代理方法名
                        if ("getParameter".equals(methodName)){
                            //调用目标对象的方法
                            String value = req.getParameter(args[0].toString());

                            for (String s : list) {
                                //过滤无效数据
                                if (value.contains(s)){
                                    value = value.replace(s, "****");
                                }
                            }
                            //返回结果值
                            return value;
                        } else {
                            returnValue = method.invoke(req, args);
                        }
                        return returnValue;
                    }
                }
        );
        filterChain.doFilter(proxy, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
