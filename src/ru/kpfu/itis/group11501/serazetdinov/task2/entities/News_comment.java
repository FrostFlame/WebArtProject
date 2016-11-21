package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 1 on 02.11.2016.
 */
public class News_comment {
    private long id;
    private long user_id;
    private long news_id;
    private String text;
    private String date;
    private User user;
    private News news;

    public News_comment(long id, long user_id, long news_id, String text, Timestamp date) {
        this.id = id;
        this.user_id = user_id;
        this.news_id = news_id;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
