package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 06.10.2016.
 */
@WebFilter(filterName = "Filters.LoginCookieFilter")
public class LoginCookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest)req).getCookies();
        String name = null;
        String value = null;
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("username")) {
                name = cookie.getName();
                value = cookie.getValue();
                break;
            }
        }
        if(name != null) {
            ((HttpServletRequest) req).getSession().setAttribute("current_user", value);
            chain.doFilter(req, resp);
        }
        else{
            ((HttpServletResponse)resp).sendRedirect("/login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
