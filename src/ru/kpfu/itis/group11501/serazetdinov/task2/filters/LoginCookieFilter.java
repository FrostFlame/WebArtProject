package ru.kpfu.itis.group11501.serazetdinov.task2.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 1 on 06.10.2016.
 */
public class LoginCookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        String name = null;
        String value = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                name = cookie.getName();
                value = cookie.getValue();
                break;
            }
        }
        if (name != null) {
            ((HttpServletRequest) req).getSession().setAttribute("current_user", value);
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
