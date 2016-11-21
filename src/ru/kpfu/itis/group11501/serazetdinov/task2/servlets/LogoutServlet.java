package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 29.09.2016.
 */
public class LogoutServlet extends HttpServlet {
    CookieService cookieService = new CookieServiceImpl();
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        request.getSession().removeAttribute("current_user");
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        String c = cookieService.getCookieById(user.getId());
        if (c != null)
            cookieService.deleteRelation(user.getId());
        response.sendRedirect("/login");
    }
}
