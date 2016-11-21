package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.FriendServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.FriendService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 20.11.2016.
 */
public class AddFriendServlet extends HttpServlet {
    FriendService friendService = new FriendServiceImpl();
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        friendService.addFriend(userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId(), Long.parseLong(request.getParameter("fr_id")));
        response.sendRedirect("/private?id=" + request.getParameter("fr_id"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
