package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 19.11.2016.
 */
public class FriendsServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    FriendService friendService = new FriendServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        friendService.deleteFromFriends(userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId(), Long.parseLong(request.getParameter("friend_id")));
        response.sendRedirect("/friends");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        List<User> friends = userService.getFriendsById(user.getId());
        root.put("user", user);
        root.put("friends", friends);
        Helpers.render(request, response, "friends.ftl", root);
    }
}
