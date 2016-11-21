package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;


import ru.kpfu.itis.group11501.serazetdinov.task2.entities.News;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.NewsServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.News_genreServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.NewsService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.News_genreService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 06.11.2016.
 */
public class FeedServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    NewsService newsService = new NewsServiceImpl();
    News_genreService news_genreService = new News_genreServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Map<String, Object> root = new HashMap<>();
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        root.put("user", user);
        if (id == null) {
            String order = request.getParameter("order");
            Map<News, Integer> news = newsService.getAllPosts(order);
            root.put("news", news);
            Helpers.render(request, response, "feed.ftl", root);
        }
        else{
            News news = newsService.getNewsById(Long.parseLong(id));
            List<String> tags = news_genreService.getGenresByNewsId(Long.parseLong(id));
            String tagsstr = "";
            if (tags.size() != 0){
                for (int i = 0; i < tags.size() - 1; i++){
                    tagsstr += tags.get(i);
                }
                tagsstr += tags.get(tags.size() - 1);
                root.put("tags", tagsstr);
            }
            root.put("news", news);
            Helpers.render(request, response, "post.ftl", root);
        }
    }
}
