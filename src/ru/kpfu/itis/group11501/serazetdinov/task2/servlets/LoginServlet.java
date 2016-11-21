package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;

/**
 * Created by 1 on 28.09.2016.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String login = request.getParameter("username");
        String password = Helpers.md5Custom(request.getParameter("password"));
        String remember = request.getParameter("remember");
        userService.loginUser(login, password, remember, request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String log = "";
        if (request.getParameter("log") != null)
            log = request.getParameter("log");
        String err = null;
        if (request.getParameter("err") != null)
            err = request.getParameter("err");
        Map<String, Object> root = new HashMap<>();
        root.put("log", log);
        root.put("err", err);
        Helpers.render(request, response, "login.ftl", root);
    }
}
