package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.News;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.NewsService;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 06.11.2016.
 */
public class NewsServiceImpl implements NewsService {
    private NewsDAO newsDAO = new NewsDAOImpl();
    private GenreDAO genreDAO = new GenreDAOImpl();
    private News_genreDAO news_genreDAO = new News_genreDAOImpl();

    @Override
    public Map<News, Integer> getAllPostsByUser(long id) {
        List<News>news = newsDAO.getAllPostsByUser(id);
        Map<News, Integer> posts = new HashMap<>();
        for(News n: news){
            LikeDAO likeDAO = new LikeDAOImpl();
            int likes = likeDAO.getAmountOfLikesOfByImageId(n.getImage_id());
            posts.put(n, likes);
        }
        return posts;
    }

    @Override
    public void createPost(String title, String text, long user_id, long image_id, String genres) {
        newsDAO.createNews(title, text, user_id, image_id);
        if(genres != null) {
            String[] genresl = genres.split(", ");
            for (String genre : genresl) {
                if (!genre.equals("")) {
                    if (genreDAO.getGenreByName(genre) == null) {
                        genreDAO.createGenre(genre);
                    }
                    news_genreDAO.createRelation(newsDAO.getNewsByTitle(title).getId(),
                            genreDAO.getGenreByName(genre).getId());
                }
            }
        }
    }

    @Override
    public Map<News, Integer> getAllPosts(String order) {
        List<News>news = newsDAO.getAllPosts(order);
        Map<News, Integer> posts = new HashMap<>();
        for(News n: news){
            LikeDAO likeDAO = new LikeDAOImpl();
            int likes = likeDAO.getAmountOfLikesOfByImageId(n.getImage_id());
            posts.put(n, likes);
        }
        return posts;
    }

    @Override
    public News getNewsById(long id) {
        return newsDAO.getNewsById(id);
    }


}
