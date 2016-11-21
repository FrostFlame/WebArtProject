package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.News;

import java.util.Map;

/**
 * Created by 1 on 06.11.2016.
 */
public interface NewsService {
    Map<News, Integer> getAllPostsByUser(long id);

    void createPost(String title, String text, long user_id, long image_id, String tags);

    Map<News,Integer> getAllPosts(String order);

    News getNewsById(long id);
}
