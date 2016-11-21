package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;


//import services.*;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by 1 on 25.10.2016.
 */
public class PrivateServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ImageService imageService = new ImageServiceImpl();
    private NewsService newsService = new NewsServiceImpl();
    private FriendService friendService = new FriendServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String id = request.getParameter("id");
        String fr = null;
        if (id == null || Long.parseLong(id) == userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId()){
            user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
            id = null;
        }
        else{
            user = userService.getUserById(Long.parseLong(request.getParameter("id")));
            fr = friendService.isFriend(Long.parseLong(id), userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId());
        }
        Image image = imageService.getImageById(user.getImage_id());
        Map<News, Integer>news = newsService.getAllPostsByUser(user.getId());
        int count_posts = news.size();
        int count_friends = friendService.countFriendsById(user.getId());
        List<String>genres = userService.getFavouriteGenresByUserId(user.getId());
        Map<String, Object> root = new HashMap<>();
        if (genres.size() != 0) {
            String genresstr = "";
            for (int i = 0; i < genres.size() - 1; i++) {
                genresstr += genres.get(i) + ", ";
            }
            genresstr += genres.get(genres.size() - 1);
            root.put("genres", genresstr);
        }
        root.put("user", user);
        root.put("image", image);
        root.put("news", news);
        root.put("count_posts", count_posts);
        root.put("count_friends", count_friends);
        if (id != null) {
            root.put("id", id);
            root.put("fr", fr);
        }
        Helpers.render(request, response, "private.ftl", root);
    }
}
