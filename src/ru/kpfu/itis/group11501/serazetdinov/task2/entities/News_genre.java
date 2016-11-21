package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class News_genre {
    private long id;
    private long news_id;
    private long genres_id;
    private News news;
    private Genre genre;

    public News_genre(long id, long news_id, long genre_id) {
        this.id = id;
        this.news_id = news_id;
        this.genres_id = genre_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public long getGenres_id() {
        return genres_id;
    }

    public void setGenres_id(long genre_id) {
        this.genres_id = genre_id;
    }
}
