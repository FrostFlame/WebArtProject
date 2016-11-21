package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 18.11.2016.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        List<User>users = null;
        if (request.getParameter("search") != null){
            String search = request.getParameter("search");
            users = userService.getUsersSearch(search);
            root.put("users", users);
        }
        root.put("user", user);
        Helpers.render(request, response, "search.ftl", root);
    }
}
