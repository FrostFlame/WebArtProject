package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 21.10.2016.
 */
@WebFilter(filterName = "UnLoginFilter")
public class UnLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest)req).getSession().getAttribute("current_user") == null){
            chain.doFilter(req, resp);
        }
        else{
            ((HttpServletResponse)resp).sendRedirect("/private");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
