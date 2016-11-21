package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.News;

import java.util.List;

/**
 * Created by 1 on 06.11.2016.
 */
public interface NewsDAO {
    List<News> getAllPostsByUser(long id);

    void createNews(String title, String text, long user_id, long image_id);

    News getNewsByTitle(String title);

    List<News> getAllPosts(String order);

    News getNewsById(long id);
}
