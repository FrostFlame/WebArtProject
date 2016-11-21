package ru.kpfu.itis.group11501.serazetdinov.task2.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 05.10.2016.
 */
public class UnLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest)request).getSession().getAttribute("current_user") == null) {
            chain.doFilter(request, response);
        }
        else{
            ((HttpServletResponse)response).sendRedirect("/private");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
