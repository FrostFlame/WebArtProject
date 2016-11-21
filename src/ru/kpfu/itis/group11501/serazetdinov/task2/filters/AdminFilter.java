package ru.kpfu.itis.group11501.serazetdinov.task2.filters;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Users_Roles;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.AdminServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.AdminService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 21.11.2016.
 */
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpServletRequest request = (HttpServletRequest)req;
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        long id = user.getId();
        AdminService adminService = new AdminServiceImpl();
        long role_id = adminService.getRoleId(id);
        if (role_id == 2){
            chain.doFilter(req, resp);
        }
        else ((HttpServletResponse)resp).sendRedirect("/private");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
