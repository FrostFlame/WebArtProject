package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.AdminServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.AdminService;
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
 * Created by 1 on 20.11.2016.
 */
public class AdminServlet extends HttpServlet{
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        Map<String, Object> root = new HashMap<>();
        root.put("user", user);
        if (request.getParameter("table") == null) {
            List<String> tables = adminService.getTables();
            root.put("tables", tables);
        }else{
            List<String> columns = adminService.getColumnsFromTable(request.getParameter("table"));
            List<Object> objects = adminService.getObjectsFromTable(request.getParameter("table"));
            root.put("columns", columns);
            root.put("objects", objects);
        }
        Helpers.render(request, response, "admin.ftl", root);
    }
}
