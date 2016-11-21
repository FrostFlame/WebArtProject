package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 1 on 02.11.2016.
 */
public class News {
    private long id;
    private long user_id;
    private String title;
    private String text;
    private String date;
    private long image_id;
    private User user;
    private Image image;

    public News(long id, long user_id, String title, String text, Timestamp date, long image_id, Image image) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
        this.image_id = image_id;
        this.image = image;
    }

    public News(long id, long user_id, String title, String text, Timestamp date, long image_id, User user, Image image) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
        this.image_id = image_id;
        this.user = user;
        this.image = image;
    }

    public News(long id, long user_id, String title, String text, Timestamp date, long image_id) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
        this.image_id = image_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
