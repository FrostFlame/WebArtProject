package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.NewsDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Image;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.News;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.ImageServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.ImageService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 1 on 06.11.2016.
 */
public class NewsDAOImpl implements NewsDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public List<News> getAllPostsByUser(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from News where user_id = ? order by date");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            List<News>news = new LinkedList<>();
            while (rs.next()){
                ImageService imageService = new ImageServiceImpl();
                Image image = imageService.getImageById(rs.getLong("image_id"));
                News post = new News(rs.getLong("Id"), id, rs.getString("title"), rs.getString("text"),
                        rs.getTimestamp("date"), rs.getLong("image_id"), image);
                news.add(post);
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void createNews(String title, String text, long user_id, long image_id) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into News(user_id, title, text, date, image_id)values(?, ?, ?, Now(), ?)");
            st.setLong(1, user_id);
            st.setString(2, title);
            st.setString(3, text);
            st.setLong(4, image_id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public News getNewsByTitle(String title) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from News where title like ?");
            st.setString(1, "%" + title + "%");
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                ImageService imageService = new ImageServiceImpl();
                Image image = imageService.getImageById(rs.getLong("image_id"));
                return new News(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("text"),
                        rs.getTimestamp("date"), rs.getLong("image_id"), image);
            }
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<News> getAllPosts(String order) {
        try {
            PreparedStatement st = null;
            if(order == null){
                st = conn.prepareStatement("select * from news");
            }
            else if (order.equals("recent")) {
                st = conn.prepareStatement("select * from News order by date");
            }
            else if(order.equals("titles")){
                st = conn.prepareStatement("select * from news order by title");
            }
            ResultSet rs = st.executeQuery();
            List<News>news = new LinkedList<>();
            while (rs.next()){
                ImageService imageService = new ImageServiceImpl();
                UserService userService = new UserServiceImpl();
                Image image = imageService.getImageById(rs.getLong("image_id"));
                User user = userService.getUserById(rs.getLong("user_id"));
                News post = new News(rs.getLong("Id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("text"),
                        rs.getTimestamp("date"), rs.getLong("image_id"), user, image);
                news.add(post);
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public News getNewsById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from news where id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            News news = null;
            if(rs.next()){
                ImageService imageService = new ImageServiceImpl();
                UserService userService = new UserServiceImpl();
                Image image = imageService.getImageById(rs.getLong("image_id"));
                User user = userService.getUserById(rs.getLong("user_id"));
                news = new News(rs.getLong("Id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("text"),
                        rs.getTimestamp("date"), rs.getLong("image_id"), user, image);
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }
}
