package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 1 on 02.11.2016.
 */
public class Battle {
    private long id;
    private long from_user_id;
    private long to_user_id;
    private String title;
    private long from_image_id;
    private long to_image_id;
    private String date;
    private String end_date;
    private User from_user;
    private User to_user;
    private Image from_image;
    private Image to_image;

    public Battle(long id, long from_user_id, long to_user_id, String title, long from_image_id, long to_image_id, Timestamp date, Timestamp end_date) {
        this.id = id;
        this.from_user_id = from_user_id;
        this.to_user_id = to_user_id;
        this.title = title;
        this.from_image_id = from_image_id;
        this.to_image_id = to_image_id;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
        this.date = s.format(end_date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(long from_user_id) {
        this.from_user_id = from_user_id;
    }

    public long getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(long to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFrom_image_id() {
        return from_image_id;
    }

    public void setFrom_image_id(long from_image_id) {
        this.from_image_id = from_image_id;
    }

    public long getTo_image_id() {
        return to_image_id;
    }

    public void setTo_image_id(long to_image_id) {
        this.to_image_id = to_image_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
